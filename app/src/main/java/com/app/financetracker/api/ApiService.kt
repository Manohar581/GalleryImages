package com.app.financetracker.api

import com.app.financetracker.interview.model.GalleryResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getGalleryImages() : Response<GalleryResponse>
}