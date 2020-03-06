package com.laam.tmdbclientkotlin.model.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.model.Movie
import com.laam.tmdbclientkotlin.model.MovieResponseDB
import com.laam.tmdbclientkotlin.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieStoreRepository @Inject constructor(
    val application: Application
) {

    private var movieList: ArrayList<Movie> = arrayListOf()
    private var mutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMutableLiveData(): MutableLiveData<List<Movie>> {
        RetrofitInstance.getService()
            .getPopularMovies(application.applicationContext.getString(R.string.API_KEY))
            .enqueue(object : Callback<MovieResponseDB> {
                override fun onResponse(
                    call: Call<MovieResponseDB>,
                    response: Response<MovieResponseDB>
                ) {
                    response.body()?.movies?.let {
                        movieList = it as ArrayList<Movie>
                        mutableLiveData.value = movieList
                    }
                }

                override fun onFailure(call: Call<MovieResponseDB>, t: Throwable) {

                }
            })

        return mutableLiveData
    }
}