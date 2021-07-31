package com.movie.bestrelases.home.moviedetail.domain.usecase

import com.movie.bestrelases.home.moviedetail.data.remote.model.MovieDetailModel
import com.movie.bestrelases.home.moviedetail.domain.repository.MovieDetailRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(private val repository: MovieDetailRepository) {

    fun getMovie(id: Int): Single<MovieDetailModel> {
        return repository.getMovie(id)
    }

}