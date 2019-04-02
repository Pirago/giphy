package com.example.giphyapi.ui.gif.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.giphyapi.data.Gif
import com.example.giphyapi.data.GifRepository

class DetailGifViewModel(application: Application): AndroidViewModel(application) {

    var gifId: MutableLiveData<Int> = MutableLiveData()

    var gif: LiveData<Gif> = Transformations.switchMap(gifId) { id -> GifRepository.getById(id.toString()) }
}