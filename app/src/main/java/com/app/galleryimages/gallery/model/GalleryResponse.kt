package com.app.galleryimages.gallery.model

data class GalleryResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)