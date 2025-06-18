package org.kamalnathvg.mobirr.di

import org.kamalnathvg.mobirr.core.di.coreModule
import org.kamalnathvg.mobirr.radarr.di.radarrModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            coreModule,
            radarrModule
        )
    }
}