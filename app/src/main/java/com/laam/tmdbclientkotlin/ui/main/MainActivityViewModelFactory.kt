package com.laam.tmdbclientkotlin.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laam.tmdbclientkotlin.model.datasource.MovieDataSourceFactory
import com.laam.tmdbclientkotlin.model.repository.MovieStoreRepository
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor(
    val movieDataSourceFactory: MovieDataSourceFactory,
    val movieStoreRepository: MovieStoreRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainActivityViewModel(
            movieStoreRepository,
            movieDataSourceFactory
        ) as T
}