package org.kamalnathvg.mobirr.radarr.data

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.appendPathSegments
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.CreditResource
import org.kamalnathvg.mobirr.safeCall

internal class RadarrRepositoryImpl(
    private val httpClient: HttpClient
) : RadarrRepository {
    override suspend fun getAllMovies(): Result<List<MovieDto>> {
        return safeCall {
            httpClient.get(ALL_MOVIES_URL) {
                apiParameter()
            }
        }
    }

    override suspend fun getMovieById(movieId: Int): Result<MovieDto> {
        return safeCall {
            httpClient.get(MOVIE_BY_ID_URL){
                movieByIdParams(movieId)
            }
        }
    }

    override suspend fun getCreditResources(movieId: Int): Result<List<CreditResource>> {
        return safeCall {
            httpClient.get(CREDIT_RESOURCE_URL){
                creditResourceParams(movieId)
            }
        }
    }

    override suspend fun lookupMovie(searchTerm: String): Result<List<MovieDto>>{
        return safeCall {
            httpClient.get(MOVIE_LOOKUP_URL) {
                movieLookupParams(searchTerm)
            }
        }
    }


    companion object {
        private const val BASE_URL = "http://100.113.11.77:7878"
        private const val API_VERSION = "/api/v3"

        private const val ALL_MOVIES_URL = "$BASE_URL$API_VERSION/movie"

        private const val MOVIE_BY_ID_URL = "$BASE_URL$API_VERSION/movie"

        private const val CREDIT_RESOURCE_URL = "$BASE_URL$API_VERSION/credit"

        private const val MOVIE_LOOKUP_URL = "$BASE_URL$API_VERSION/movie/lookup"
        private fun HttpRequestBuilder.apiParameter() {
            return this.parameter("apikey", "1260b1d7a9a242e385cf03984c07c10d")
        }

        private fun movieByIdParams(movieId: Int): HttpRequestBuilder.() -> Unit = {
            url{
                appendPathSegments("id", movieId.toString())
            }
            apiParameter()
        }

        private fun creditResourceParams(movieId: Int): HttpRequestBuilder.() -> Unit = {
            url{
                appendPathSegments("movieId", movieId.toString())
            }
            apiParameter()
        }

        private fun movieLookupParams(searchTerm: String): HttpRequestBuilder.() -> Unit = {
            url{
                appendPathSegments("term", searchTerm)
            }
            apiParameter()
        }
    }
}