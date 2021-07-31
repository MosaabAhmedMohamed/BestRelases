package com.movie.bestrelases.home.moviedetail.di

import com.movie.bestrelases.home.moviedetail.data.remote.client.MovieDetailApi
import com.movie.bestrelases.home.moviedetail.data.repository.MovieDetailRepositoryImpl
import com.movie.bestrelases.home.moviedetail.domain.repository.MovieDetailRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class MovieDetailModule {

    @Provides
    fun provideMovieApi(retrofit: Retrofit.Builder): MovieDetailApi {
        return retrofit
            .build()
            .create(MovieDetailApi::class.java)
    }

    @Provides
    fun provideMovieDetailRepository(api: MovieDetailApi): MovieDetailRepository =
        MovieDetailRepositoryImpl(api)


}