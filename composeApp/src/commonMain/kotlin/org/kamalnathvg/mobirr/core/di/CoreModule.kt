package org.kamalnathvg.mobirr.core.di

import io.ktor.client.HttpClient
import org.kamalnathvg.mobirr.HttpClientFactory
import org.kamalnathvg.mobirr.createHttpClient
import org.koin.dsl.module

val coreModule = module {
    single<HttpClient> { HttpClientFactory.create(get()) }
}