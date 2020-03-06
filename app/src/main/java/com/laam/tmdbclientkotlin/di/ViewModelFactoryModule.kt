package com.laam.tmdbclientkotlin.di

import androidx.lifecycle.ViewModelProvider
import com.laam.tmdbclientkotlin.util.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}