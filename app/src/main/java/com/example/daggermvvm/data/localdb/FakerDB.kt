package com.example.daggermvvm.data.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggermvvm.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {
    abstract fun getFakerDao(): FakerDAO
}