package org.kamalnathvg.mobirr.settings.domain

import org.kamalnathvg.mobirr.settings.data.SettingsRepository

internal class CheckConnectionUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(url: String): Result<Unit>{
        return settingsRepository.checkConnection(url)
    }
}