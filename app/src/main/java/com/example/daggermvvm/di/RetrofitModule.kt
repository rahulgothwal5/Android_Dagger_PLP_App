package com.example.daggermvvm.di

import com.example.daggermvvm.data.remote.FakerAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun providesBase(): String {
        return "https://fakestoreapi.com/"
    }

    @Provides
    fun providesRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesFakerAPI(retrofit: Retrofit): FakerAPI {
        return retrofit.create(FakerAPI::class.java)
    }
}