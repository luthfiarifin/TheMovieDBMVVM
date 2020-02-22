package com.laam.tmdbclientkotlin.model

import com.google.gson.annotations.SerializedName

data class MovieResponseDB(
    val page: Int,
    @SerializedName("result")
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)