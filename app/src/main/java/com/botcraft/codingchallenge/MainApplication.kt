package com.botcraft.codingchallenge

import android.app.Application
import androidx.multidex.MultiDex
import com.botcraft.codingchallenge.di.module.AppModule
import com.botcraft.codingchallenge.di.module.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(listOf(AppModule, NetworkModule))
        }

    }
}