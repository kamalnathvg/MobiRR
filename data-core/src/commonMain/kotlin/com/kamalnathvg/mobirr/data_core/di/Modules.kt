package com.kamalnathvg.mobirr.data_core.di

import com.kamalnathvg.mobirr.data_core.getHttpClientEngine
import com.kamalnathvg.mobirr.data_core.networking.createHttpClient
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val dataCoreModule = module {
    includes(platformModule)
    single<HttpClient>{ createHttpClient(getHttpClientEngine()) }
}

internal expect val platformModule: Module