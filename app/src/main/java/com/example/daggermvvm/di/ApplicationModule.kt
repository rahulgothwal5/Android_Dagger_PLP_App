package com.example.daggermvvm.di

import android.content.Context
import com.example.daggermvvm.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataSourceModule::class,
        LocalDBModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        ViewModelModule::class]
)
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}