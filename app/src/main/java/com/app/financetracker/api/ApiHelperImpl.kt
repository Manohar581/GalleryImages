package com.app.financetracker.api

import com.app.financetracker.interview.model.GalleryResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService : ApiService) : ApiHelper {
    override suspend fun getImageGallery() = apiService.getGalleryImages()
}