package com.app.financetracker.interview

import com.app.financetracker.api.ApiHelper
import com.app.financetracker.api.ApiHelperImpl
import com.app.financetracker.api.ApiService
import com.app.financetracker.interview.model.GalleryResponse
import retrofit2.Response
import javax.inject.Inject

class InterviewRepository @Inject constructor(private val apiHelper : ApiHelperImpl) {
    suspend fun getGalleryImages() : Response<GalleryResponse> {
       return apiHelper.getImageGallery()
    }
}