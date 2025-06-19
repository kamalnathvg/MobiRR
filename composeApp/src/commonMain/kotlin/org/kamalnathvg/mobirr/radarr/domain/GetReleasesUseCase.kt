package org.kamalnathvg.mobirr.radarr.domain

import org.kamalnathvg.mobirr.radarr.data.RadarrRepository
import org.kamalnathvg.mobirr.radarr.data.ReleaseDto

internal class GetReleasesUseCase(
    private val radarrRepository: RadarrRepository
) {
    suspend operator fun invoke(movieId: Int): Result<List<ReleaseDto>> {
        return radarrRepository.getReleases(movieId)
    }
}