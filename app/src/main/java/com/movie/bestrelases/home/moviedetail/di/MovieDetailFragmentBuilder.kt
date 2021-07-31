package com.movie.bestrelases.home.moviedetail.di

import com.movie.bestrelases.home.moviedetail.ui.fragment.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MovieDetailFragmentBuilder {


    @ContributesAndroidInjector
    abstract fun provideMovieDetail() : MovieDetailFragment
}