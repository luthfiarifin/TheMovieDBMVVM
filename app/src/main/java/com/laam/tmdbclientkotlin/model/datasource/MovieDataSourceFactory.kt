package com.laam.tmdbclientkotlin.model.datasource

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.laam.tmdbclientkotlin.model.Movie
import com.laam.tmdbclientkotlin.network.MovieAPI


class MovieDataSourceFactory(
    val application: Application,
    private val movieAPI: MovieAPI
) : DataSource.Factory<Long, Movie>() {
    private lateinit var movieDataSource: MovieDataSource

    private var mutableLiveData: MutableLiveData<MovieDataSource> = MutableLiveData()

    override fun create(): DataSource<Long, Movie> {
        movieDataSource = MovieDataSource(application, movieAPI)
        mutableLiveData.postValue(movieDataSource)
        return movieDataSource
    }

    fun getMutableLiveData(): MutableLiveData<MovieDataSource> = mutableLiveData
}