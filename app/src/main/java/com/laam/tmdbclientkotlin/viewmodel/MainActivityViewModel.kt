package com.laam.tmdbclientkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.laam.tmdbclientkotlin.model.Movie
import com.laam.tmdbclientkotlin.repository.MovieStoreRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val movieStoreRepository = MovieStoreRepository(application)

    fun getAllMovies(): LiveData<List<Movie>> = movieStoreRepository.getMutableLiveData()
}