package com.app.galleryimages.api

import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService : ApiService) : ApiHelper {
    override suspend fun getImageGallery() = apiService.getGalleryImages()
}