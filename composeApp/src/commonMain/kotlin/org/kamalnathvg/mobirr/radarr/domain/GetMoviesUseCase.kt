package org.kamalnathvg.mobirr.radarr.domain

import co.touchlab.kermit.Logger
import org.kamalnathvg.mobirr.radarr.data.MovieDto
import org.kamalnathvg.mobirr.radarr.data.RadarrRepository
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toMovie

private const val TAG = "GetMoviesUseCase"

internal class GetMoviesUseCase(
    private val radarrRepository: RadarrRepository
) {
    suspend operator fun invoke(): Result<List<Movie>> {
        val result: Result<List<MovieDto>> = radarrRepository.getAllMovies()
        return result.fold(
            onSuccess = {
                Logger.d(TAG) { "Success... Found ${it.size} movies" }
                Result.success(
                    it.map { it.toMovie() }
                )
            },
            onFailure = {
                Logger.e(TAG) { "Error: $it" }
                Result.failure(it)
            }
        )
    }
}