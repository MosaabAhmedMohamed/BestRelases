package com.example.core.moviedetail.presentation.viewstate

import com.example.core.movies.presentation.uimodels.MovieUIModel

sealed class MovieDetailViewState() {

    object Loading : MovieDetailViewState()
    data class onSuccess(val result: MovieUIModel) : MovieDetailViewState()
    data class onError(val error: Throwable) : MovieDetailViewState()

}
