package com.laam.tmdbclientkotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.databinding.MovieListItemBinding
import com.laam.tmdbclientkotlin.model.Movie

class MovieAdapter(
    val clickListener: ClickListener
) : PagedListAdapter<Movie, MovieAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val movieListItemBinding: MovieListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_list_item,
            parent,
            false
        )

        return ViewHolder(movieListItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = getItem(position)

        holder.movieListItemBinding.movie = currentMovie
    }

    inner class ViewHolder(val movieListItemBinding: MovieListItemBinding) :
        RecyclerView.ViewHolder(movieListItemBinding.root) {

        init {
            movieListItemBinding.root.setOnClickListener {
                getItem(adapterPosition)?.let {
                    clickListener.onClickItemListener(it)
                }
            }
        }
    }

    interface ClickListener {
        fun onClickItemListener(movie: Movie)
    }
}

val diffCallback: DiffUtil.ItemCallback<Movie> = object : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = true
}