package com.example.daggermvvm.di

import androidx.lifecycle.ViewModel
import com.example.daggermvvm.presentation.viewmodel.ProductsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @ClassKey(ProductsListViewModel::class)
    @IntoMap
    abstract fun bindProductsViewModel(viewModel: ProductsListViewModel): ViewModel


}