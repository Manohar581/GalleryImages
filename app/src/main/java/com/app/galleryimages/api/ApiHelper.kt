package com.app.galleryimages.api

import com.app.galleryimages.gallery.model.GalleryResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getImageGallery() : Response<GalleryResponse>
}