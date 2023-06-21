package com.app.galleryimages.gallery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.galleryimages.api.Resource
import com.app.galleryimages.gallery.repository.InterviewRepository
import com.app.galleryimages.gallery.model.GalleryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterviewViewModel @Inject constructor(private val interviewRepository: InterviewRepository) :
    ViewModel() {

    private var _galleryLiveData = MutableLiveData<Resource<GalleryResponse>>()

    val galleryLiveData: LiveData<Resource<GalleryResponse>>
        get() = _galleryLiveData

    fun getGalleryImages() {
        viewModelScope.launch(Dispatchers.IO) {
            interviewRepository.getGalleryImages().let { it ->
                if (it.isSuccessful) {
                    _galleryLiveData.postValue(Resource.success(it.body()))
                } else {
                    _galleryLiveData.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        }
    }
}