package io.indrian16.koinmvvm

import android.app.Application
import io.indrian16.koinmvvm.di.appModule
import io.indrian16.koinmvvm.di.repoModule
import org.koin.android.ext.android.startKoin

class KoinMvvmApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, arrayListOf(

            appModule,
            repoModule
        ))
    }
}