package com.app.financetracker.di

import com.app.financetracker.BuildConfig
import com.app.financetracker.core.util.Constants
import com.app.financetracker.api.ApiHelper
import com.app.financetracker.api.ApiHelperImpl
import com.app.financetracker.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Named("GalleryBaseUrl")
    fun provideGalleryBaseUrl() = Constants.GALLERY_BASE_URL

    @Singleton
    @Provides
    fun provideOkhttpClient() = if(BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel((HttpLoggingInterceptor.Level.BODY))
        OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient().newBuilder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okhttpClient : OkHttpClient, @Named("GalleryBaseUrl")BASE_URL : String) : Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okhttpClient)
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper : ApiHelperImpl) : ApiHelper = apiHelper

}