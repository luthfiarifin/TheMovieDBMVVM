package com.laam.tmdbclientkotlin.di

import android.app.Application
import com.laam.tmdbclientkotlin.model.repository.MovieStoreRepository
import dagger.Module
import dagger.Provides

@Module
class MovieStoreRepositoryModule {

    @Provides
    fun provideMovieRepository(application: Application) =
        MovieStoreRepository(application)
}