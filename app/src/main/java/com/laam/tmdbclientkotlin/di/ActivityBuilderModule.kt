package com.laam.tmdbclientkotlin.di

import com.laam.tmdbclientkotlin.di.main.MainModule
import com.laam.tmdbclientkotlin.di.main.MainScope
import com.laam.tmdbclientkotlin.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}