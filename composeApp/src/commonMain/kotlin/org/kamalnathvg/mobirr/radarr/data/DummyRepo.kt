package org.kamalnathvg.mobirr.radarr.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import mobirr.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.CreditResource

internal sealed interface DummyRepo{
    data class DynamicString(val value: String): DummyRepo
    class RawResourceId(
        val id: StringResource,
        val args: Array<Any> = arrayOf()
    ): DummyRepo

    private suspend inline fun <reified T> getDataFromJson(file: String): Result<T>{
        return withContext(Dispatchers.IO) {
             runCatching {
                val bytes = Res.readBytes(file)
                val json = Json {ignoreUnknownKeys = true}
                json.decodeFromString<T>(bytes.decodeToString())
            }
        }
    }

    suspend fun getMovies(): List<MovieDto>{
        val result = getDataFromJson<List<MovieDto>>(file = DUMMY_MOVIE_FILE)
        return result.getOrElse { emptyList() }
    }

    suspend fun getDummyMetadata(): List<CreditResource>{
        val result = getDataFromJson<List<CreditResource>>(file =DUMMY_CREDITS_FILE)
        return result.getOrElse { emptyList() }
    }
    companion object{
        const val DUMMY_MOVIE_FILE = "files/dummyMovies.json"
        const val DUMMY_CREDITS_FILE = "files/dummyCredits.json"
    }
}

