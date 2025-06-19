package org.kamalnathvg.mobirr.radarr.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import mobirr.composeapp.generated.resources.Res

internal class DummyRadarrRepository : RadarrRepository {

    private suspend fun getMovies(): List<MovieDto> =
        getDataFromJson<List<MovieDto>>(file = DUMMY_MOVIE_FILE).getOrElse { emptyList() }

    override suspend fun getAllMovies(): Result<List<MovieDto>> =
        getDataFromJson<List<MovieDto>>(file = DUMMY_MOVIE_FILE)

    override suspend fun getMovieById(movieId: Int): Result<MovieDto> {
        val movies = getMovies()
        return Result.success(movies.first())
    }

    override suspend fun getCreditResources(movieId: Int): Result<List<CreditResource>> =
        getDataFromJson<List<CreditResource>>(file = DUMMY_CREDITS_FILE)

    override suspend fun lookupMovie(searchTerm: String): Result<List<MovieDto>> =
        Result.success(emptyList())

    override suspend fun addMovie(movieId: Int): Result<Unit> = Result.success(Unit)

    override suspend fun removeMovieFile(fileId: Int): Result<Unit> = Result.success(Unit)

    override suspend fun removeMovie(movieId: Int): Result<Unit> = Result.success(Unit)

    override suspend fun getReleases(movieId: Int): Result<List<ReleaseDto>> =
        getDataFromJson<List<ReleaseDto>>(file = DUMMY_RELEASES_FILE)

    override suspend fun addRelease(releaseDto: ReleaseDto): Result<Unit> = Result.success(Unit)

    private suspend inline fun <reified T> getDataFromJson(file: String): Result<T> {
        return withContext(Dispatchers.IO) {
            runCatching {
                val bytes = Res.readBytes(file)
                val json = Json { ignoreUnknownKeys = true }
                json.decodeFromString<T>(bytes.decodeToString())
            }
        }
    }

    companion object {
        private const val DUMMY_MOVIE_FILE = "files/dummyMovies.json"
        private const val DUMMY_CREDITS_FILE = "files/dummyCredits.json"
        private const val DUMMY_RELEASES_FILE = "files/dummyReleases.json"
        private const val DUMMY_LOOKUP_FILE = "files/dummyLookup.json"
    }

}

