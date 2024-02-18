package com.example.daggermvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daggermvvm.data.localdb.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDBModule {

    @Provides
    fun provideFakerDB(@ApplicationContext context: Context): FakerDB {
        return Room.databaseBuilder(context = context, FakerDB::class.java, "FakeDB").build()
    }

}