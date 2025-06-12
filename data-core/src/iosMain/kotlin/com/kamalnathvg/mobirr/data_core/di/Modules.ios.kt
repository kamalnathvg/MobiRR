package com.kamalnathvg.mobirr.data_core.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.kamalnathvg.mobirr.data_core.createDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single<DataStore<Preferences>> { createDataStore() }
}