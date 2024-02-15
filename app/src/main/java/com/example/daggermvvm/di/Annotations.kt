package com.example.daggermvvm.di

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class LocalDBDataSource

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class RemoteDataSource