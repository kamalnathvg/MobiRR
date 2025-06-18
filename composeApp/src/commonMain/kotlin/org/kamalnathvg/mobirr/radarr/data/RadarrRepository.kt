package org.kamalnathvg.mobirr.radarr.data

import org.kamalnathvg.mobirr.radarr.presentation.movie_details.CreditResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.ReleaseDto

internal interface RadarrRepository {
    suspend fun getAllMovies(): Result<List<MovieDto>>
    suspend fun getMovieById(movieId: Int): Result<MovieDto>
    suspend fun getCreditResources(movieId: Int): Result<List<CreditResource>>
    suspend fun lookupMovie(searchTerm: String): Result<List<MovieDto>>
    suspend fun addMovie(movieId: Int): Result<Unit>
    suspend fun removeFile(fileId: Int): Result<Unit>
    suspend fun removeMovie(movieId: Int): Result<Unit>
    suspend fun getReleases(movieId: Int): Result<List<ReleaseDto>>
    suspend fun addRelease(releaseDto: ReleaseDto): Result<Unit>
}




