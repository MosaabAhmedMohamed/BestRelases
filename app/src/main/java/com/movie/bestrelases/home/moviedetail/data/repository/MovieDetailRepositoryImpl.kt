package com.movie.bestrelases.home.moviedetail.data.repository

import com.movie.bestrelases.home.moviedetail.data.remote.client.MovieDetailApi
import com.movie.bestrelases.home.moviedetail.data.remote.model.MovieDetailModel
import com.movie.bestrelases.home.moviedetail.domain.repository.MovieDetailRepository
import com.movie.bestrelases.util.data.APIConst.Companion.API_KEY
import io.reactivex.Single
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(private val api: MovieDetailApi) :
    MovieDetailRepository {

    override fun getMovie(id: Int): Single<MovieDetailModel> {
        return api.getMovieDetail(id, API_KEY)
    }

}