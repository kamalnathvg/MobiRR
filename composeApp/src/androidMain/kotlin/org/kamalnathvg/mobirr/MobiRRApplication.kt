package org.kamalnathvg.mobirr

import android.app.Application
import org.kamalnathvg.mobirr.di.initKoin
import org.koin.android.ext.koin.androidContext

class MobiRRApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin{
            // androidContext(this@MobiRRApplication)
        }
    }
}