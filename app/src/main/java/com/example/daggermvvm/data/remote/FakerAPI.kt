package com.example.daggermvvm.data.remote

import com.example.daggermvvm.data.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}