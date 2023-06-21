package com.app.galleryimages.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.galleryimages.databinding.ItemGalleryBinding
import com.app.galleryimages.gallery.model.Product
import com.bumptech.glide.Glide


class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.MyViewHolder>() {

    var productList: List<Product> = mutableListOf()
    private var listener: ((Product) -> Unit)? = null

    class MyViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Product) {
            binding.tvName.text = data.title
            binding.tvDescription.text = data.description
            val url = data.thumbnail
            Glide.with(binding.ivGallery)
                .load(url)
                .into(binding.ivGallery)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemGalleryBinding =
            ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(productList[position])
        holder.binding.root.setOnClickListener {
            listener?.let {
                it(productList[position])
            }
        }
    }

    override fun getItemCount() = productList.size

    fun setData(list: List<Product>) {
        this.productList = list
    }

    fun itemClickListener(l: (Product) -> Unit) {
        listener = l
    }
}