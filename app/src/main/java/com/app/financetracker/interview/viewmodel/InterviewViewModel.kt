package com.app.financetracker.interview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.financetracker.interview.InterviewRepository
import com.app.financetracker.interview.model.GalleryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class InterviewViewModel @Inject constructor(private val interviewRepository: InterviewRepository) :
    ViewModel() {

    private var _galleryLiveData: MutableLiveData<GalleryResponse> =
        MutableLiveData<GalleryResponse>()
    val galleryLiveData: LiveData<GalleryResponse>
        get() = _galleryLiveData

    fun getGalleryImages() {
        viewModelScope.launch(Dispatchers.IO) {
            interviewRepository.getGalleryImages().let { it ->
                if (it.isSuccessful) {
                    launch(Dispatchers.Main) {
                        _galleryLiveData.value = it.body()
                    }


                } else {

                }
            }

        }
    }
}