package com.kamalnathvg.mobirr.data_core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.engine.darwin.Darwin

actual fun platform() = "iOS"
actual fun getHttpClientEngine() = Darwin.create()