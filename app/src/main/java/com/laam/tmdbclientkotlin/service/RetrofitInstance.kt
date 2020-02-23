package com.laam.tmdbclientkotlin.service

import com.laam.tmdbclientkotlin.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun getService(): MovieDataService {
        return retrofit.create(MovieDataService::class.java)
    }
}