package com.example.giphyapi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Gif::class], version = 1, exportSchema = false)
abstract class GifDatabase : RoomDatabase() {

    abstract fun gifDao(): GifDao

    companion object {
        fun buildInstance(context: Context) = Room
            .databaseBuilder(context, GifDatabase::class.java, "GifDatabase")
            .build()
    }
}