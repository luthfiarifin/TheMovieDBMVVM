package com.laam.tmdbclientkotlin.model.datasource

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.laam.tmdbclientkotlin.model.Movie


class MovieDataSourceFactory(
    val application: Application
) : DataSource.Factory<Long, Movie>() {
    private lateinit var movieDataSource: MovieDataSource

    private var mutableLiveData: MutableLiveData<MovieDataSource> = MutableLiveData()

    override fun create(): DataSource<Long, Movie> {
        movieDataSource = MovieDataSource(application)
        mutableLiveData.postValue(movieDataSource)
        return movieDataSource
    }

    fun getMutableLiveData(): MutableLiveData<MovieDataSource> = mutableLiveData
}