package com.mmg.clocks

import android.app.Application
import com.mmg.clocks.di.domainModule
import com.mmg.clocks.di.networkModule
import com.mmg.clocks.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ClocksApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@ClocksApp)
            androidLogger(Level.ERROR)
            modules(
                listOf(
                    presentationModule,
                    networkModule,
                    domainModule
                )
            )
        }
    }

}