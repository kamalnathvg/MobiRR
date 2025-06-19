package org.kamalnathvg.mobirr.settings.data

internal interface SettingsRepository {
    suspend fun checkConnection(url: String): Result<Unit>
    suspend fun saveConfiguration(url: String): Result<Unit>
}