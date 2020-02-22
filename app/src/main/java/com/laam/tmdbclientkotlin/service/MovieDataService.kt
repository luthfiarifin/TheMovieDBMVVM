package com.laam.tmdbclientkotlin.service

import com.laam.tmdbclientkotlin.model.MovieResponseDB
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<MovieResponseDB>
}