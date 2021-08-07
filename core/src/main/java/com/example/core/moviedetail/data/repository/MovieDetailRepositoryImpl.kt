package com.example.core.moviedetail.data.repository

import com.example.core.moviedetail.data.remote.client.MovieDetailApi
import com.example.core.moviedetail.data.remote.model.MovieDetailModel
import com.example.core.moviedetail.domain.repository.MovieDetailRepository
import com.example.core.util.data.APIConst.Companion.API_KEY
import io.reactivex.Single
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(private val api: MovieDetailApi) :
    MovieDetailRepository {

    override fun getMovie(id: Int): Single<MovieDetailModel> {
        return api.getMovieDetail(id, API_KEY)
    }

}