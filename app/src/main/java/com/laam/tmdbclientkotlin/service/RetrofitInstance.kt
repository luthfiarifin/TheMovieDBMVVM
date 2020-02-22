package com.laam.tmdbclientkotlin.service

import com.laam.tmdbclientkotlin.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    var retrofit: Retrofit? = null

    fun getService(): MovieDataService {
        retrofit?.let {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit?.create(MovieDataService::class.java)!!
    }
}