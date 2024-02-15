package com.example.daggermvvm.di

import com.example.daggermvvm.data.datasource.DataSource
import com.example.daggermvvm.data.datasource.LocalDBDataSourceImpl
import com.example.daggermvvm.data.datasource.RemoteDataSourceImpl
import com.example.daggermvvm.data.localdb.FakerDB
import com.example.daggermvvm.data.remote.FakerAPI
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @RemoteDataSource
    @Singleton
    fun providesRemoteDataSource(fakerAPI: FakerAPI): DataSource {
        return RemoteDataSourceImpl(fakerAPI)
    }

    @Provides
    @LocalDBDataSource
    @Singleton
    fun providesLocalDBDataSource(fakerDB: FakerDB): DataSource {
        return LocalDBDataSourceImpl(fakerDB)
    }
}