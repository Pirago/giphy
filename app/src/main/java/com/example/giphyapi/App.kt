package com.example.giphyapi

import android.app.Application
import com.example.giphyapi.data.GifRepository

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        GifRepository.initialize(this)
    }
}