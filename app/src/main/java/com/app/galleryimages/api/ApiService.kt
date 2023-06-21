package com.app.galleryimages.api

import com.app.galleryimages.gallery.model.GalleryResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getGalleryImages() : Response<GalleryResponse>
}