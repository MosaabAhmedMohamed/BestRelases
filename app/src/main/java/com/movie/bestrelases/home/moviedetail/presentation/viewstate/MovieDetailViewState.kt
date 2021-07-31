package com.movie.bestrelases.home.moviedetail.presentation.viewstate

import com.movie.bestrelases.home.movies.presentation.uimodels.MovieUIModel

sealed class MovieDetailViewState() {

    object Loading : MovieDetailViewState()
    data class onSuccess(val result: MovieUIModel) : MovieDetailViewState()
    data class onError(val error: Throwable) : MovieDetailViewState()

}
