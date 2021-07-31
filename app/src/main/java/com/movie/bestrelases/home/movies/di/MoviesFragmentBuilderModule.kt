package com.movie.bestrelases.home.movies.di

import com.movie.bestrelases.home.movies.ui.fragment.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoviesFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideMoviesFragment(): MoviesFragment

}