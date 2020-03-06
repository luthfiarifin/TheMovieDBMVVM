package com.laam.tmdbclientkotlin.network

import com.laam.tmdbclientkotlin.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun getService(): MovieAPI {
        return retrofit.create(MovieAPI::class.java)
    }
}