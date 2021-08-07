package com.example.core.movies.di

import com.example.core.movies.data.remote.client.MoviesApi
import com.example.core.movies.data.repository.MoviesRepositoryImpl
import com.example.core.movies.domain.repository.MoviesRepository
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