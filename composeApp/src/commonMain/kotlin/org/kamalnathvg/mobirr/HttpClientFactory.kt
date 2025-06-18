package org.kamalnathvg.mobirr

import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.json.Json
import kotlin.coroutines.coroutineContext
import co.touchlab.kermit.Logger as KermitLogger


fun createHttpClient(engine: HttpClientEngine): HttpClient {
    return HttpClient(engine)
}

object HttpClientFactory {
    fun create(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    })
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        KermitLogger.v("Http Client") { message }
                    }

                }
                level = LogLevel.ALL
            }
            defaultRequest {
                accept(ContentType.Application.Json)
            }
        }
    }
}

sealed class NetworkError : Exception() {
    object BadRequest : NetworkError()
    object UnauthorizedError : NetworkError()
    object Forbidden : NetworkError()
    object NotFound : NetworkError()
    object RequestTimeout : NetworkError()
    object NotAcceptable : NetworkError()
    object NoInternetConnection : NetworkError()
    object ServerError : NetworkError()
    data class HttpError(val code: Int, override val message: String?) : NetworkError()
    data class SerializationError(override val cause: Throwable?) : NetworkError()
    data class Unknown(override val cause: Throwable? = null) : NetworkError()

}


suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T> {
    val response = try {
        execute()
    } catch (_: SocketTimeoutException) {
        return Result.failure(NetworkError.RequestTimeout)
    } catch (_: UnresolvedAddressException) {
        return Result.failure(NetworkError.NoInternetConnection)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.failure(NetworkError.Unknown(e))
    }
    return response.toResult()
}


suspend inline fun <reified T> HttpResponse.toResult(): Result<T> {
    return when (this.status.value) {
        in 200..299 -> {
            try {
                Result.success(this.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.failure(NetworkError.SerializationError(cause = e.cause))
            }
        }

        400 -> Result.failure(NetworkError.BadRequest)

        401 -> Result.failure(NetworkError.UnauthorizedError)

        403 -> Result.failure(NetworkError.Forbidden)

        404 -> Result.failure(NetworkError.NotFound)

        406 -> Result.failure(NetworkError.NotAcceptable)

        408 -> Result.failure(NetworkError.RequestTimeout)

        in 500..599 -> Result.failure(NetworkError.ServerError)

        else -> Result.failure<T>(NetworkError.Unknown(cause = Exception(this.status.description)))
            .also {
                KermitLogger.e("KtorClient") { "Unknown Error Occurred: ${this.status}" }
            }
    }
}