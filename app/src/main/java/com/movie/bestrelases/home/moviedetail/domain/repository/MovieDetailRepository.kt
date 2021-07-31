package com.movie.bestrelases.home.moviedetail.domain.repository

import com.movie.bestrelases.home.moviedetail.data.remote.model.MovieDetailModel
import io.reactivex.Single

interface MovieDetailRepository {
    fun getMovie(id: Int): Single<MovieDetailModel>
}