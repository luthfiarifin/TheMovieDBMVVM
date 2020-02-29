package com.laam.tmdbclientkotlin

import android.app.Application
import com.laam.tmdbclientkotlin.di.AndroidAppModule
import com.laam.tmdbclientkotlin.di.DaggerTMDBAppComponent
import com.laam.tmdbclientkotlin.di.TMDBAppComponent

class BaseApp : Application() {
    companion object {
        private lateinit var baseApp: BaseApp

        fun getBaseApp(): BaseApp = baseApp
    }

    private lateinit var tmdbAppComponent: TMDBAppComponent

    override fun onCreate() {
        super.onCreate()

        baseApp = this
        tmdbAppComponent = DaggerTMDBAppComponent.builder()
            .androidAppModule(AndroidAppModule(this))
            .build()
    }

    fun getTmdbAppComponent(): TMDBAppComponent = tmdbAppComponent
}