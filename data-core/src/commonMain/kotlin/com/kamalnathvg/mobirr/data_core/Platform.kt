package com.kamalnathvg.mobirr.data_core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.engine.HttpClientEngine
import okio.Path.Companion.toPath

expect fun platform(): String

expect fun getHttpClientEngine(): HttpClientEngine
