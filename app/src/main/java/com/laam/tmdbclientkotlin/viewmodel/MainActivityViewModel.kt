package com.laam.tmdbclientkotlin.viewmodel

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

class MainActivityViewModel(
    val movieStoreRepository: MovieStoreRepository,
    factory: MovieDataSourceFactory
) : ViewModel() {

    private var movieDataSourceLiveData: MutableLiveData<MovieDataSource>
    private var executor: Executor
    private lateinit var moviePagedList: LiveData<PagedList<Movie>>

    init {
        movieDataSourceLiveData = factory.getMutableLiveData()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(20)
            .setPrefetchDistance(4)
            .build()

        executor = Executors.newFixedThreadPool(5)

        moviePagedList = LivePagedListBuilder<Long, Movie>(factory, config)
            .setFetchExecutor(executor)
            .build()
    }

    fun getAllMovies(): LiveData<List<Movie>> = movieStoreRepository.getMutableLiveData()
    fun getMoviePagedList(): LiveData<PagedList<Movie>> = moviePagedList
}