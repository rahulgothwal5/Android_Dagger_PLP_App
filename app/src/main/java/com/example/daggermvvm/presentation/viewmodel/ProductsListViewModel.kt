package com.example.daggermvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvm.data.model.Product
import com.example.daggermvvm.presentation.common.Result
import com.example.daggermvvm.domain.usecases.GetProductsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val getProductsListUseCase: GetProductsListUseCase
) : ViewModel() {


    private val _productsList: MutableStateFlow<ProductListUIState> =
        MutableStateFlow(ProductListUIState.Loading)
    val productsList = _productsList


    private fun fetchProducts() {
        viewModelScope.launch {
            getProductsListUseCase.invoke().collect { result ->
                when (result) {

                    is Result.Success -> {
                        _productsList.value = ProductListUIState.Success(result.data!!)
                    }

                    is Result.Error -> {
                        _productsList.value = ProductListUIState.Error(result.exception)
                    }
                }
            }
        }
    }

    init {
        fetchProducts()
    }

    sealed class ProductListUIState {
        data class Success(val products: List<Product>) : ProductListUIState()
        object Loading : ProductListUIState()
        data class Error(val exception: Exception) : ProductListUIState()
    }
}