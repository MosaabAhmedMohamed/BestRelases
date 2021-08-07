package com.example.core.moviedetail.presentation.uimodel

import com.example.core.moviedetail.data.remote.model.MovieDetailModel
import com.example.core.movies.presentation.uimodels.MovieUIModel


fun MovieDetailModel.mapToUI(): MovieUIModel {
    return MovieUIModel(id, title, release_date, vote_average, overview)
}