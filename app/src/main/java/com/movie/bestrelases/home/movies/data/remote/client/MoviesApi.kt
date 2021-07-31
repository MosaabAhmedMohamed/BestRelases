package com.movie.bestrelases.home.movies.data.remote.client

import com.movie.bestrelases.home.movies.data.remote.model.MovieModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") pageNumber: Int
    ): Single<MovieModel>
}