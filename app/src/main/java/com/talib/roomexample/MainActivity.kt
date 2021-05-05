package com.talib.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var youtubeRV: RecyclerView
    private lateinit var fab: FloatingActionButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youtubeRV = findViewById(R.id.youtubeRV)
        fab = findViewById(R.id.fab)

        val dao = GalleryDatabase.getDatabase(this).galleryDao()


        val factory = MyViewModelFactory(dao)
        val viewModel = ViewModelProvider(this,factory).get(MyViewModel::class.java)

        val myAdapter = YoutubeAdapter()

        youtubeRV.adapter = myAdapter

        viewModel.photos.observe(this,{list->
            list?.let {
                myAdapter.differ.submitList(list)
                //viewModel.getAllPhotos()
            }

        })

        fab.setOnClickListener {
            viewModel.addPhoto(GalleryModel(null,"adsdsadas","dasdsad","dasdasd"))
        }











    }


}