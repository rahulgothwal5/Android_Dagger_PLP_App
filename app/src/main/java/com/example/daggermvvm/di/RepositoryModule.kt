package com.example.daggermvvm.di

import com.example.daggermvvm.data.datasource.DataSource
import com.example.daggermvvm.domain.repo.ProductRepository
import com.example.daggermvvm.domain.repo.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(
       @LocalDBDataSource localDBDataSource: DataSource,
       @RemoteDataSource remoteDataSource: DataSource,
    ): ProductRepository {
        return ProductRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDBDataSource = localDBDataSource
        )
    }

}