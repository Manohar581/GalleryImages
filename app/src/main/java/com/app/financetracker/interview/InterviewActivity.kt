package com.app.financetracker.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.financetracker.R
import com.app.financetracker.databinding.ActivityInterviewBinding
import com.app.financetracker.interview.viewmodel.InterviewViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InterviewActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityInterviewBinding
    private val binding get() = _binding

    private val viewModel : InterviewViewModel by viewModels()
    private var interviewAdapter = InterviewAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInterviewBinding.inflate(layoutInflater)
        setAdapter()
        callAPI()
    }

    private fun callAPI() {
        viewModel.getGalleryImages()
        viewModel.galleryLiveData.observe(this, Observer {
            val products = it.products
            interviewAdapter.setData(products)
        })
    }

    private fun setAdapter() {
        val interviewAdapter = InterviewAdapter()
        binding.rvGallery.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = interviewAdapter
        }
    }
}