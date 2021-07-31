package com.movie.bestrelases.home.moviedetail.presentation.uimodel

import com.movie.bestrelases.home.moviedetail.data.remote.model.MovieDetailModel
import com.movie.bestrelases.home.movies.presentation.uimodels.MovieUIModel


fun MovieDetailModel.mapToUI(): MovieUIModel {
    return MovieUIModel(id, title, release_date, vote_average, overview)
}