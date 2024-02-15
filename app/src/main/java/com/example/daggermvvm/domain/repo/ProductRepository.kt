package com.example.daggermvvm.domain.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvm.data.datasource.DataSource
import com.example.daggermvvm.data.model.Product
import com.example.daggermvvm.di.LocalDBDataSource
import com.example.daggermvvm.di.RemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ProductRepository {
    suspend fun getProducts():  Result<List<Product>?>
}

class ProductRepositoryImpl @Inject constructor(
    @LocalDBDataSource private val localDBDataSource: DataSource,
    @RemoteDataSource private val remoteDataSource: DataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ProductRepository {

    override suspend fun getProducts(): Result<List<Product>?> {
        return withContext(ioDispatcher) {
            try {
                val result = remoteDataSource.fetchProductsFromServer()
                if (result.isSuccessful && result.body() != null) {
                    localDBDataSource.saveProductsToDB(result.body()!!)
                    Result.success(result.body())
                } else {
                    Result.failure(Exception("Failed to fetch topics: ${result.code()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }


}
