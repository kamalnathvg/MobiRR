package org.kamalnathvg.mobirr.radarr.data

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.kamalnathvg.mobirr.safeCall

internal class RadarrRepositoryImpl(
    private val httpClient: HttpClient
) : RadarrRepository {
    override suspend fun getAllMovies(): Result<List<MovieDto>> {
        return makeNetworkCall {
            safeCall {
                httpClient.get(ALL_MOVIES_URL) {
                    apiParam()
                }
            }
        }
    }

    override suspend fun getMovieById(movieId: Int): Result<MovieDto> {
        return makeNetworkCall {
            safeCall {
                httpClient.get(MOVIE_BY_ID_URL) {
                    url {
                        appendPathSegments(movieId.toString())
                        apiParam()
                    }
                }
            }
        }
    }

    override suspend fun getCreditResources(movieId: Int): Result<List<CreditResource>> {
        return makeNetworkCall {
            safeCall {
                httpClient.get(CREDIT_RESOURCE_URL) {
                    url {
                        apiParam()
                        movieIdParam(movieId)
                    }
                }
            }
        }
    }

    override suspend fun lookupMovie(searchTerm: String): Result<List<MovieDto>> {
        return makeNetworkCall {
            safeCall {
                httpClient.get(MOVIE_LOOKUP_URL) {
                    url {
                        apiParam()
                        movieLookupParam(searchTerm)
                    }
                }
            }
        }
    }

    override suspend fun addMovie(movieId: Int): Result<Unit> {
        return makeNetworkCall {
            safeCall {
                httpClient.post {
                    apiParam()
                    //TODO: add required params
                }
            }
        }
    }

    override suspend fun removeMovieFile(fileId: Int): Result<Unit> {
        return makeNetworkCall {
            safeCall {
                httpClient.delete(DELETE_MOVIE_FILE_URL) {
                    url {
                        appendPathSegments(fileId.toString())
                    }
                    apiParam()
                }
            }
        }
    }

    override suspend fun removeMovie(movieId: Int): Result<Unit> = Result.success(Unit)

    override suspend fun getReleases(movieId: Int): Result<List<ReleaseDto>> {
        return makeNetworkCall {
            safeCall {
                httpClient.get(RELEASE_URL) {
                    apiParam()
                    movieIdParam(movieId)
                }
            }
        }
    }

    override suspend fun addRelease(releaseDto: ReleaseDto): Result<Unit> {
        return makeNetworkCall {
            safeCall {
                httpClient.post(RELEASE_URL) {
                    apiParam()
                    setBody(releaseDto)
                }
            }
        }
    }

    private suspend fun <T> makeNetworkCall(networkCall: suspend () -> Result<T>): Result<T> {
        return withContext(Dispatchers.IO) {
            networkCall()
        }
    }

    companion object {

        private const val DEMO_API_KEY = "1260b1d7a9a242e385cf03984c07c10d"

        private const val BASE_URL = "http://100.113.11.77:7878"
        private const val API_VERSION = "/api/v3"
        private const val RADARR_URL = "$BASE_URL$API_VERSION"

        private const val ALL_MOVIES_URL = "$RADARR_URL/movie"
        private const val MOVIE_BY_ID_URL = "$RADARR_URL/movie"

        private const val DELETE_MOVIE_FILE_URL = "$RADARR_URL/moviefile"

        private const val MOVIE_LOOKUP_URL = "$RADARR_URL/movie/lookup"

        private const val CREDIT_RESOURCE_URL = "$RADARR_URL/credit"

        private const val RELEASE_URL = "$RADARR_URL/release"

        private fun HttpRequestBuilder.apiParam() {
            return this.url.parameters.append("apikey", DEMO_API_KEY)
        }

        private fun HttpRequestBuilder.movieIdParam(movieId: Int) {
            return this.url.parameters.append("movieId", movieId.toString())
        }

        private fun HttpRequestBuilder.movieLookupParam(searchTerm: String) {
            return this.url.parameters.append("term", searchTerm)
        }
    }
}