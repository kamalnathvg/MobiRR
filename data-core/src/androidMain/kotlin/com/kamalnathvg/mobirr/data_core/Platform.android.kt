package com.kamalnathvg.mobirr.data_core

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual fun platform() = "Android"
actual fun getHttpClientEngine(): HttpClientEngine = OkHttp.create()