package com.example.giphyapi.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import org.jetbrains.anko.doAsync

object GifRepository {

    private lateinit var database: GifDatabase

    private lateinit var gifDao: GifDao

    //private val service = MovieService.create()

    fun initialize(application: Application) {
        database =
            GifDatabase.buildInstance(application)
        gifDao = database.gifDao()
    }

    //region locale
    fun insertAll(g: List<Gif>) = doAsync {
        gifDao.insertAll(g)
        Log.d("gifRepository","inserting gif: $g")
    }

    fun insert(g: Gif) = insertAll(listOf(g))

    fun delete(g: Gif) = doAsync { gifDao.delete(g) }

    fun getById(id: String): LiveData<Gif> = gifDao.getById(id)

    fun getAll(): LiveData<List<Gif>> = gifDao.getAllLive()

    //endregion
}

