package com.example.giphyapi.ui.gif.create

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.giphyapi.data.Gif
import com.example.giphyapi.data.GifRepository

class CreateGifViewModel(application: Application): AndroidViewModel(application) {
    var title: String = ""
    var username: String = ""
    var url: String = ""

    fun insert() {
        GifRepository.insert(
            Gif(
                title = title,
                username = username,
                url = url
            )
        )
    }
}