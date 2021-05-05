package com.talib.roomexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel(val dao: GalleryDao) : ViewModel() {

    lateinit var photos: LiveData<List<GalleryModel>>

    init {
        getAllPhotos()
    }

    fun getAllPhotos() = viewModelScope.launch {
        photos = dao.getAllPhotos()
    }

    fun addPhoto(galleryModel: GalleryModel) = viewModelScope.launch {
        dao.addPhoto(galleryModel)
    }

}