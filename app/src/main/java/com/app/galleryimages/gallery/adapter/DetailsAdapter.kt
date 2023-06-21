package com.app.galleryimages.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.galleryimages.databinding.ItemDetailsBinding
import com.app.galleryimages.gallery.model.Product
import com.bumptech.glide.Glide

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.MyViewHolder>() {

    var imageList: List<String> = mutableListOf()

    class MyViewHolder(val binding: ItemDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            Glide.with(binding.ivGallery)
                .load(data)
                .into(binding.ivGallery)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemDetailsBinding =
            ItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount() = imageList.size

    fun setData(list: List<String>) {
        this.imageList = list
    }
}