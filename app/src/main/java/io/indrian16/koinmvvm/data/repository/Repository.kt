package io.indrian16.koinmvvm.data.repository

import android.os.Handler
import io.indrian16.koinmvvm.util.Constant

class Repository {

    fun getHello(callback: RepoCallback) {

        Handler().postDelayed({

            callback.helloKoin("Hello Koin")

        }, Constant.DELAY_POST) // 1500L
    }

    interface RepoCallback {

        fun helloKoin(message: String)
    }
}