package com.laam.tmdbclientkotlin.di.main

import androidx.lifecycle.ViewModel
import com.laam.tmdbclientkotlin.di.ViewModelKey
import com.laam.tmdbclientkotlin.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}