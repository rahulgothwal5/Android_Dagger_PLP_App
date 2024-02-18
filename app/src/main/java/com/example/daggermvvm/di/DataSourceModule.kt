package com.example.daggermvvm.di

import com.example.daggermvvm.data.datasource.DataSource
import com.example.daggermvvm.data.datasource.LocalDBDataSourceImpl
import com.example.daggermvvm.data.datasource.RemoteDataSourceImpl
import com.example.daggermvvm.data.localdb.FakerDB
import com.example.daggermvvm.data.remote.FakerAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @RemoteDataSource
    fun providesRemoteDataSource(fakerAPI: FakerAPI): DataSource {
        return RemoteDataSourceImpl(fakerAPI)
    }

    @Provides
    @LocalDBDataSource
    fun providesLocalDBDataSource(fakerDB: FakerDB): DataSource {
        return LocalDBDataSourceImpl(fakerDB)
    }
}