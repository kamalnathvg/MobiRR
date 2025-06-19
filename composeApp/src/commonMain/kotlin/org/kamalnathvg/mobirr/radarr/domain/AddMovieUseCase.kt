package org.kamalnathvg.mobirr.radarr.domain

import org.kamalnathvg.mobirr.radarr.data.RadarrRepository

internal class AddMovieUseCase(
    private val radarrRepository: RadarrRepository
) {
    suspend operator fun invoke(movieId: Int): Result<Unit>{
        return radarrRepository.addMovie(movieId)
    }
}