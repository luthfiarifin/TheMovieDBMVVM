package com.laam.tmdbclientkotlin.di

import com.laam.tmdbclientkotlin.view.MainActivity
import dagger.Component

@Component(
    modules = [
        AndroidAppModule::class,
        MovieStoreRepositoryModule::class,
        MovieDataSourceFactoryModule::class
    ]
)
interface TMDBAppComponent {

    fun inject(mainActivity: MainActivity)
}