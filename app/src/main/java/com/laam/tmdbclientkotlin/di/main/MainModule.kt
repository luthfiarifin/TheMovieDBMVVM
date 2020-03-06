package com.laam.tmdbclientkotlin.di.main

import android.app.Application
import com.laam.tmdbclientkotlin.model.datasource.MovieDataSourceFactory
import com.laam.tmdbclientkotlin.model.repository.MovieStoreRepository
import com.laam.tmdbclientkotlin.network.MovieAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object MainModule {

    @MainScope
    @JvmStatic
    @Provides
    fun provideMovieRepository(application: Application) =
        MovieStoreRepository(application)

    @MainScope
    @JvmStatic
    @Provides
    fun provideMovieDataSourceFactory(application: Application) =
        MovieDataSourceFactory(application)

    @MainScope
    @JvmStatic
    @Provides
    fun provideMovieAPI(retrofit: Retrofit): MovieAPI =
        retrofit.create(MovieAPI::class.java)

}