package org.kamalnathvg.mobirr.di

import com.kamalnathvg.mobirr.data_core.di.dataCoreModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            dataCoreModule
        )
    }
}