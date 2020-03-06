package com.laam.tmdbclientkotlin.network

import com.laam.tmdbclientkotlin.model.MovieResponseDB
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<MovieResponseDB>

    @GET("movie/popular")
    fun getPopularMoviesWithPaging(
        @Query("api_key") apiKey: String,
        @Query("page") page: Long
    ): Call<MovieResponseDB>
}