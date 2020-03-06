package com.laam.tmdbclientkotlin.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.laam.tmdbclientkotlin.BaseActivity
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.databinding.ActivityMovieBinding
import com.laam.tmdbclientkotlin.util.MOVIE_KEY_INTENT
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity() {

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
