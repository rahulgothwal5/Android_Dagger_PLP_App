package com.example.daggermvvm.domain.usecases

import com.example.daggermvvm.domain.repo.ProductRepository
import com.example.daggermvvm.presentation.common.Result
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsListUseCase @Inject constructor(private val repository: ProductRepository) {
    operator fun invoke() = flow {
        try {
            val result = repository.getProducts()
            if (result.isSuccess) {
                emit(Result.Success(result.getOrNull()))
            } else {
                emit(Result.Error(Exception("Failed to fetch tweets for topic '': ${result.exceptionOrNull()?.message}")))
            }
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}