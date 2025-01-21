package com.example.watchmodeapp

import android.app.Application
import com.example.watchmodeapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class WatchmodeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@WatchmodeApplication)
            modules(appModule)
        }
    }
}