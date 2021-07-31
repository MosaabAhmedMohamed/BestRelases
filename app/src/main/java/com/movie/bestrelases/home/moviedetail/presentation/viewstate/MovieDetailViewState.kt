package com.movie.bestrelases.home.moviedetail.presentation.viewstate

import com.movie.bestrelases.home.moviedetail.data.remote.model.MovieDetailModel

sealed class MovieDetailViewState() {

    object Loading : MovieDetailViewState()
    data class onSuccess(val result: MovieDetailModel) : MovieDetailViewState()
    data class onError(val error: Throwable) : MovieDetailViewState()

}
