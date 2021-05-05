package com.talib.roomexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load

class YoutubeAdapter: RecyclerView.Adapter<YoutubeAdapter.YoutubeViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<GalleryModel>() {
        override fun areItemsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class YoutubeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val thumbnailImage: ImageView = itemView.findViewById(R.id.thumbnailImage)
        val title: TextView = itemView.findViewById(R.id.videoTitle)
        val desc: TextView = itemView.findViewById(R.id.videoDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.youtube_custom_layout,parent,false)
        val viewHolder = YoutubeViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        holder.thumbnailImage.load(differ.currentList[position].image)
        holder.title.text = differ.currentList[position].title
        holder.desc.text = differ.currentList[position].desc
    }

    override fun getItemCount(): Int = differ.currentList.size
}