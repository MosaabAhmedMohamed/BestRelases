package com.movie.bestrelases.di

import com.movie.bestrelases.home.moviedetail.di.MovieDetailFragmentBuilder
import com.movie.bestrelases.home.moviedetail.di.MovieDetailModule
import com.movie.bestrelases.home.movies.di.MoviesFragmentBuilderModule
import com.movie.bestrelases.home.movies.di.MoviesModule
import com.movie.bestrelases.home.movies.ui.activity.HomeActivity
import com.movie.bestrelases.splash.ui.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [MoviesFragmentBuilderModule::class, MoviesModule::class,
            MovieDetailFragmentBuilder::class, MovieDetailModule::class]
    )
    abstract fun binHomeActivity(): HomeActivity


    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

}