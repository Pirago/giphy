package com.example.giphyapi.ui.gif.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.giphyapi.data.Gif
import com.example.giphyapi.data.GifRepository

class ListGifViewModel(application: Application):AndroidViewModel(application){
    var gifs: LiveData<List<Gif>> = GifRepository.getAll()

    fun delete(gif: Gif) {
        GifRepository.delete(gif)
    }
}