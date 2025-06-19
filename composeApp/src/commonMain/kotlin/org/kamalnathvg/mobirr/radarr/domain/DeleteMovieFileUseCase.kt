package org.kamalnathvg.mobirr.radarr.domain

import org.kamalnathvg.mobirr.radarr.data.RadarrRepository

internal class DeleteMovieFileUseCase(
    private val radarrRepository: RadarrRepository
) {
    suspend operator fun invoke(movieFileId: Int): Result<Unit>{
        return radarrRepository.removeMovieFile(fileId = movieFileId)
    }
}