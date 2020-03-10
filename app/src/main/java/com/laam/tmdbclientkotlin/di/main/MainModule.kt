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
    fun provideMovieRepository(application: Application, movieAPI: MovieAPI) =
        MovieStoreRepository(application, movieAPI)

    @MainScope
    @JvmStatic
    @Provides
    fun provideMovieDataSourceFactory(application: Application, movieAPI: MovieAPI) =
        MovieDataSourceFactory(application, movieAPI)

    @MainScope
    @JvmStatic
    @Provides
    fun provideMovieAPI(retrofit: Retrofit): MovieAPI =
        retrofit.create(MovieAPI::class.java)

}