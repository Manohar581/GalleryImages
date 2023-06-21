package com.app.financetracker.interview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.financetracker.R
import com.app.financetracker.databinding.ItemGalleryBinding
import com.app.financetracker.interview.model.Product
import com.bumptech.glide.Glide

class InterviewAdapter : RecyclerView.Adapter<InterviewAdapter.MyViewHolder>() {

    var productList = mutableListOf<Product>()

    class MyViewHolder(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Product) {
            binding.tvName.text = data.brand
            binding.tvDescription.text = data.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemGalleryBinding =
            ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun setData(list: List<Product>) {
        productList.clear()
        productList.addAll(list)
        notifyDataSetChanged()
    }
}