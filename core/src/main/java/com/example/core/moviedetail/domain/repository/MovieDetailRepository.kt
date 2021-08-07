package com.example.core.moviedetail.domain.repository

import com.example.core.moviedetail.data.remote.model.MovieDetailModel
import io.reactivex.Single

interface MovieDetailRepository {
    fun getMovie(id: Int): Single<MovieDetailModel>
}