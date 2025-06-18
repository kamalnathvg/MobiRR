package org.kamalnathvg.mobirr.radarr.domain

import co.touchlab.kermit.Logger
import org.kamalnathvg.mobirr.radarr.data.RadarrRepository
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsForView
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.toMovieDetailsForView

private const val TAG = "GetMovieDetailsIdUseCase"

internal class GetMovieDetailsByIdUseCase(
    private val radarrRepository: RadarrRepository
) {
    suspend operator fun invoke(movieId: Int): Result<MovieDetailsForView> {
        val creditResources = radarrRepository.getCreditResources(movieId)
        if (creditResources.isFailure) {
            Logger.d(TAG) { "Error Fetching Credit Resources" }
        }
        radarrRepository.getMovieById(movieId).fold(
            onSuccess = { movieDto ->
                return Result.success(
                    movieDto.toMovieDetailsForView(
                        credits = creditResources.getOrNull() ?: emptyList()
                    )
                )
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }
}