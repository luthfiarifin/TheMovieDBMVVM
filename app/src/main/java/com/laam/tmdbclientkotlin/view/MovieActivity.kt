package com.laam.tmdbclientkotlin.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.laam.tmdbclientkotlin.R
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        setSupportActionBar(toolbar)


    }
}
