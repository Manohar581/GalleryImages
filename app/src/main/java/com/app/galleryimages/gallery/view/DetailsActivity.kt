package com.app.galleryimages.gallery.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.galleryimages.databinding.ActivityDetailsBinding
import com.app.galleryimages.gallery.adapter.DetailsAdapter


class DetailsActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityDetailsBinding
    private val binding get() = _binding
    private var detailsAdapter = DetailsAdapter()

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent .getSerializableExtra( "key" )
        val list: ArrayList<String>? = intent.getSerializableExtra("imageList") as ArrayList<String>?
        initAdapter()
        if (list != null) {
            detailsAdapter.setData(list.toMutableList())
            detailsAdapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter() {
        binding.rvDetails.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = detailsAdapter
        }

    }
}