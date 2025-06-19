package org.kamalnathvg.mobirr.settings.domain

import org.kamalnathvg.mobirr.settings.data.SettingsRepository

internal class SaveConfigurationUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(url: String): Result<Unit>{
        return settingsRepository.saveConfiguration(url)
    }
}