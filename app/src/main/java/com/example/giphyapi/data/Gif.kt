package com.example.giphyapi.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gif")
data class Gif(
    @PrimaryKey
    var id: String = "",
    var title: String = "Sans titre",
    var username: String = "Inconnu",
    var url: String? = null
)