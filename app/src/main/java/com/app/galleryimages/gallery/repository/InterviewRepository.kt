package com.app.galleryimages.gallery.repository

import com.app.galleryimages.api.ApiHelperImpl
import com.app.galleryimages.gallery.model.GalleryResponse
import retrofit2.Response
import javax.inject.Inject

class InterviewRepository @Inject constructor(private val apiHelper : ApiHelperImpl) {
    suspend fun getGalleryImages() : Response<GalleryResponse> {
       return apiHelper.getImageGallery()
    }
}