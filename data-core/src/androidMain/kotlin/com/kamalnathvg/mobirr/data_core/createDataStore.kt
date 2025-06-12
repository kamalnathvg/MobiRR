package com.kamalnathvg.mobirr.data_core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences


fun createDataStore(context: Context): DataStore<Preferences> = createDataStore(
    productPath = {
        context.filesDir.resolve(dataStoreFileName).absolutePath
    }
)