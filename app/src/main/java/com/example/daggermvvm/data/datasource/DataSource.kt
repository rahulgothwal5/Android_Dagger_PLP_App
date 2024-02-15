package com.example.daggermvvm.data.datasource

import com.example.daggermvvm.data.localdb.FakerDAO
import com.example.daggermvvm.data.localdb.FakerDB
import com.example.daggermvvm.data.model.Product
import com.example.daggermvvm.data.remote.FakerAPI
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface DataSource {
    suspend fun fetchProductsFromServer(): Response<List<Product>>
    suspend fun fetchProductsFromDB(): List<Product>
    suspend fun saveProductsToDB(data: List<Product>)
}

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val fakerAPI: FakerAPI) : DataSource {
    override suspend fun fetchProductsFromServer(): Response<List<Product>> {
        return fakerAPI.getProducts()
    }

    override suspend fun fetchProductsFromDB(): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun saveProductsToDB(data: List<Product>) {
        TODO("Not yet implemented")
    }
}

@Singleton
class LocalDBDataSourceImpl @Inject constructor(private val fakerDB: FakerDB) : DataSource {
    override suspend fun fetchProductsFromServer(): Response<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchProductsFromDB(): List<Product> {
        return fakerDB.getFakerDao().getProducts()
    }

    override suspend fun saveProductsToDB(data: List<Product>) {
        fakerDB.getFakerDao().addProducts(data)
    }
}