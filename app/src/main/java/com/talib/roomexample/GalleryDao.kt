package com.talib.roomexample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GalleryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPhoto(galleryModel: GalleryModel)

    @Update
    suspend fun updatePhoto(galleryModel: GalleryModel)

    @Delete
    suspend fun deletePhoto(galleryModel: GalleryModel): Int



    @Query("SELECT * FROM gallery_list WHERE id == :id")
    suspend fun findPhotoById(id: Int): GalleryModel

    @Query("SELECT * FROM gallery_list")
    fun getAllPhotos(): LiveData<List<GalleryModel>>

}