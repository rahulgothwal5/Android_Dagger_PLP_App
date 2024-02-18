package com.example.daggermvvm.di

import com.example.daggermvvm.data.datasource.DataSource
import com.example.daggermvvm.domain.repo.ProductRepository
import com.example.daggermvvm.domain.repo.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
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