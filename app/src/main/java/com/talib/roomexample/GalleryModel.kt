package com.talib.roomexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gallery_list")
data class GalleryModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val image: String,
    val title: String,
    val desc: String
)