package com.laam.tmdbclientkotlin.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.databinding.ActivityMovieBinding
import com.laam.tmdbclientkotlin.model.Movie
import com.laam.tmdbclientkotlin.util.MOVIE_KEY_INTENT
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    private lateinit var activityMovieBinding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        setSupportActionBar(toolbar)

        activityMovieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        intent?.let {
            if (it.hasExtra(MOVIE_KEY_INTENT)) {
                activityMovieBinding.movie = it.getParcelableExtra(MOVIE_KEY_INTENT)
            }
        }
    }
}
