package org.kamalnathvg.mobirr.settings.data

internal class DummySettingsRepository: SettingsRepository {
    override suspend fun checkConnection(url: String): Result<Unit> {
        return Result.success(Unit)
    }

    override suspend fun saveConfiguration(url: String): Result<Unit> {
        return Result.success(Unit)
    }
}