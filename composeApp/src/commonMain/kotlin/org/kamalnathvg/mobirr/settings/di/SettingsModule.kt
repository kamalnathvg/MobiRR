package org.kamalnathvg.mobirr.settings.di

import org.kamalnathvg.mobirr.settings.data.DummySettingsRepository
import org.kamalnathvg.mobirr.settings.data.SettingsRepository
import org.kamalnathvg.mobirr.settings.data.SettingsRepositoryImpl
import org.kamalnathvg.mobirr.settings.presentation.settings.SettingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val settingsModule = module {
    viewModelOf(::SettingViewModel)
    single<SettingsRepository> { DummySettingsRepository() }
    single<SettingsRepository> { SettingsRepositoryImpl() }
}