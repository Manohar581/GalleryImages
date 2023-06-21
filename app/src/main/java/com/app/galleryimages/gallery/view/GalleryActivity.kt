package com.app.galleryimages.gallery.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.galleryimages.api.Status
import com.app.galleryimages.databinding.ActivityGalleryBinding
import com.app.galleryimages.gallery.adapter.GalleryAdapter
import com.app.galleryimages.gallery.viewmodel.InterviewViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityGalleryBinding
    private val binding get() = _binding

    private val viewModel: InterviewViewModel by viewModels()
    private var galleryAdapter = GalleryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initClickListeners()
        callAPI()
    }

    private fun initAdapter() {
        binding.rvGallery.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = galleryAdapter
        }
    }

    private fun initClickListeners() {
        galleryAdapter.itemClickListener {
            val arrayList: ArrayList<String> = ArrayList(it.images)
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putStringArrayListExtra("imageList", arrayList);
            startActivity(intent)
        }
    }

    private fun callAPI() {
        viewModel.getGalleryImages()
        viewModel.galleryLiveData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data.let {
                        it?.let { it1 ->
                            var count = it.products.size
                            Log.d("zzz", "API success $count")
                            galleryAdapter.setData(it1.products)
                            galleryAdapter.notifyDataSetChanged()
                        }
                    }
                }

                Status.ERROR -> {
                    Log.d("zzz", "API error")
                }

                Status.LOADING -> {
                    Log.d("zzz", "Loading.....")
                }

                else -> {}
            }

        })
    }
}