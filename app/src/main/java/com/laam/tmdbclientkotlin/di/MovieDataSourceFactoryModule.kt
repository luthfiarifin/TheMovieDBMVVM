package com.laam.tmdbclientkotlin.di

import android.app.Application
import com.laam.tmdbclientkotlin.model.datasource.MovieDataSourceFactory
import dagger.Module
import dagger.Provides

@Module
class MovieDataSourceFactoryModule {

    @Provides
    fun provideMovieDataSourceFactory(application: Application) =
        MovieDataSourceFactory(application)
}