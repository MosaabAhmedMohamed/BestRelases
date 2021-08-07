package com.example.core.moviedetail.data.remote.client

import com.example.core.moviedetail.data.remote.model.MovieDetailModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailApi {

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String?
    ): Single<MovieDetailModel>

}