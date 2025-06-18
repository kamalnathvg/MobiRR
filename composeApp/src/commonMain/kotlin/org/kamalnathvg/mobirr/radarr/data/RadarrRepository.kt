package org.kamalnathvg.mobirr.radarr.data

import org.kamalnathvg.mobirr.radarr.presentation.movie_details.CreditResource

internal interface RadarrRepository {
    suspend fun getAllMovies(): Result<List<MovieDto>>
    suspend fun getMovieById(movieId: Int): Result<MovieDto>
    suspend fun getCreditResources(movieId: Int): Result<List<CreditResource>>
    suspend fun lookupMovie(searchTerm: String): Result<List<MovieDto>>
}




