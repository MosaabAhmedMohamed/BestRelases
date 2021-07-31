package com.movie.bestrelases.home.movies.di

import com.movie.bestrelases.home.movies.data.remote.client.MoviesApi
import com.movie.bestrelases.home.movies.data.repository.MoviesRepositoryImpl
import com.movie.bestrelases.home.movies.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MoviesModule {


    @Provides
    fun provideMoviesApi(retrofit: Retrofit.Builder): MoviesApi {
        return retrofit
            .build()
            .create(MoviesApi::class.java)
    }

    @Provides
    fun provideMoviesRepository(api: MoviesApi): MoviesRepository =
        MoviesRepositoryImpl(api)



}