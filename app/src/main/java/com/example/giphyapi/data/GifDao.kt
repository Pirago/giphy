package com.example.giphyapi.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GifDao {

    @Query("SELECT * FROM gif WHERE id = :id")
    fun getById(id: String): LiveData<Gif>

    @Query("SELECT * FROM gif")
    fun getAllLive(): LiveData<List<Gif>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(g: Gif)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Gif>)

    @Delete
    fun delete(g: Gif)
}