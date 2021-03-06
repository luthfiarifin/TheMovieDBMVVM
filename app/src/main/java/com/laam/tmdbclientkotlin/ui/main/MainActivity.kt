package com.laam.tmdbclientkotlin.ui.main

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.tmdbclientkotlin.BaseActivity
import com.laam.tmdbclientkotlin.BaseApplication
import com.laam.tmdbclientkotlin.R
import com.laam.tmdbclientkotlin.databinding.ActivityMainBinding
import com.laam.tmdbclientkotlin.model.Movie
import com.laam.tmdbclientkotlin.util.MOVIE_KEY_INTENT
import com.laam.tmdbclientkotlin.ui.movie.MovieActivity
import com.laam.tmdbclientkotlin.util.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity : BaseActivity(), MovieAdapter.ClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var rvMovie: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private lateinit var movies: PagedList<Movie>

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: MainActivityViewModel

    private var rvAdapter = MovieAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        rvMovie = activityMainBinding.rvMovies
        swipeRefreshLayout = activityMainBinding.swipeLayout

        viewModel = ViewModelProviders.of(this, factory)[MainActivityViewModel::class.java]

        initSwipeRefreshLayout()
        initRecyclerView()
        getPopularMovie()
    }

    private fun initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener {
            getPopularMovie()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun getPopularMovie() {
        viewModel.getMoviePagedList().observe(this, Observer {
            it?.let { pagedList ->
                movies = pagedList
                rvAdapter.submitList(movies)
            }
        })
    }

    private fun initRecyclerView() {
        rvMovie.layoutManager =
            if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                GridLayoutManager(this, 2)
            } else {
                GridLayoutManager(this, 4)
            }

        rvMovie.adapter = rvAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClickItemListener(movie: Movie) {
        Intent(this, MovieActivity::class.java).also {
            it.putExtra(MOVIE_KEY_INTENT, movie)
            startActivity(it)
        }
    }
}
