package com.laam.tmdbclientkotlin.model.datasource

import android.app.Application
import androidx.paging.PageKeyedDataSource
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.model.Movie
import com.laam.tmdbclientkotlin.model.MovieResponseDB
import com.laam.tmdbclientkotlin.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource(
    val application: Application
) : PageKeyedDataSource<Long, Movie>() {
    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, Movie>
    ) {
        RetrofitInstance.getService()
            .getPopularMoviesWithPaging(
                application.applicationContext.getString(R.string.API_KEY),
                1
            )
            .enqueue(object : Callback<MovieResponseDB> {
                override fun onResponse(
                    call: Call<MovieResponseDB>,
                    response: Response<MovieResponseDB>
                ) {
                    response.body()?.movies?.let {
                        val movieList = it as ArrayList<Movie>
                        callback.onResult(movieList, null, 2)
                    }
                }

                override fun onFailure(call: Call<MovieResponseDB>, t: Throwable) {

                }
            })
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Movie>) {
        RetrofitInstance.getService()
            .getPopularMoviesWithPaging(
                application.applicationContext.getString(R.string.API_KEY),
                params.key
            )
            .enqueue(object : Callback<MovieResponseDB> {
                override fun onResponse(
                    call: Call<MovieResponseDB>,
                    response: Response<MovieResponseDB>
                ) {
                    response.body()?.movies?.let {
                        val movieList = it as ArrayList<Movie>
                        callback.onResult(movieList, params.key + 1)
                    }
                }

                override fun onFailure(call: Call<MovieResponseDB>, t: Throwable) {

                }
            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Movie>) {

    }
}