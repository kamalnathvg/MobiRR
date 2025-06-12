package com.kamalnathvg.mobirr.data_core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath


fun createDataStore(productPath: () -> String): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = { productPath().toPath()}
    )

internal const val dataStoreFileName = "mobirrSettings.preferences_pb"
