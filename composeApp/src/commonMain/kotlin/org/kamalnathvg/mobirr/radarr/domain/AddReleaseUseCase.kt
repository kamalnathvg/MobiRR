package org.kamalnathvg.mobirr.radarr.domain

import org.kamalnathvg.mobirr.radarr.data.RadarrRepository
import org.kamalnathvg.mobirr.radarr.data.ReleaseDto

internal class AddReleaseUseCase(
    private val radarrRepository: RadarrRepository
) {
    suspend operator fun invoke(releaseDto: ReleaseDto): Result<Unit>{
        return radarrRepository.addRelease(releaseDto)
    }
}