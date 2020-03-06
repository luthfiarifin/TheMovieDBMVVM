package com.laam.tmdbclientkotlin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.laam.tmdbclientkotlin.model.Movie
import com.laam.tmdbclientkotlin.model.datasource.MovieDataSource
import com.laam.tmdbclientkotlin.model.datasource.MovieDataSourceFactory
import com.laam.tmdbclientkotlin.model.repository.MovieStoreRepository
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    val movieStoreRepository: MovieStoreRepository,
    val factory: MovieDataSourceFactory
) : ViewModel() {

    private var movieDataSourceLiveData: MutableLiveData<MovieDataSource> =
        factory.getMutableLiveData()
    private var executor: Executor
    private lateinit var moviePagedList: LiveData<PagedList<Movie>>

    init {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(20)
            .setPrefetchDistance(4)
            .build()

        executor = Executors.newFixedThreadPool(5)!!

        moviePagedList = LivePagedListBuilder<Long, Movie>(factory, config)
            .setFetchExecutor(executor)
            .build()
    }

    fun getAllMovies(): LiveData<List<Movie>> = movieStoreRepository.getMutableLiveData()
    fun getMoviePagedList(): LiveData<PagedList<Movie>> = moviePagedList
}