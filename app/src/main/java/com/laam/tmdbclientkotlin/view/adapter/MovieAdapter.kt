package com.laam.tmdbclientkotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.databinding.MovieListItemBinding
import com.laam.tmdbclientkotlin.model.Movie

class MovieAdapter(
    private val listMovie: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val movieListItemBinding: MovieListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_list_item,
            parent,
            false
        )

        return ViewHolder(movieListItemBinding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = listMovie[position]

        holder.movieListItemBinding.movie = currentMovie
    }

    inner class ViewHolder(val movieListItemBinding: MovieListItemBinding) :
        RecyclerView.ViewHolder(movieListItemBinding.root)
}