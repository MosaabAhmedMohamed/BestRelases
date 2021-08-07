package com.example.core.moviedetail.di

import com.example.core.moviedetail.data.remote.client.MovieDetailApi
import com.example.core.moviedetail.data.repository.MovieDetailRepositoryImpl
import com.example.core.moviedetail.domain.repository.MovieDetailRepository
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