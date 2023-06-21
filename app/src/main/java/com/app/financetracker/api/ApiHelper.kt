package com.app.financetracker.api

import com.app.financetracker.interview.model.GalleryResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getImageGallery() : Response<GalleryResponse>
}