package com.example.daggermvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daggermvvm.data.localdb.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDBModule {

    @Provides
    @Singleton
    fun provideFakerDB(context: Context): FakerDB {
        return Room.databaseBuilder(context = context, FakerDB::class.java, "FakeDB").build()
    }

}