package com.laam.tmdbclientkotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.databinding.MovieListItemBinding
import com.laam.tmdbclientkotlin.model.Movie

class MovieAdapter(
    val clickListener: ClickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var listMovie: ArrayList<Movie> = arrayListOf()

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

    fun setMovie(newListMovie: List<Movie>) {
        listMovie = newListMovie as ArrayList<Movie>
        notifyDataSetChanged()
    }

    inner class ViewHolder(val movieListItemBinding: MovieListItemBinding) :
        RecyclerView.ViewHolder(movieListItemBinding.root) {

        init {
            movieListItemBinding.root.setOnClickListener {
                clickListener.onClickItemListener(listMovie[adapterPosition])
            }
        }
    }

    interface ClickListener {
        fun onClickItemListener(movie: Movie)
    }
}