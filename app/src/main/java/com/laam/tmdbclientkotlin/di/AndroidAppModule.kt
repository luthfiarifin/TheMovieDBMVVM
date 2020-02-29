package com.laam.tmdbclientkotlin.di

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AndroidAppModule(val application: Application) {

    @Provides
    fun provideApplication(): Application = application
}