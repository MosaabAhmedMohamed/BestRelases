package com.movie.bestrelases.home.movies.presentation.uimodels.mapper

import com.movie.bestrelases.home.movies.data.remote.model.Results
import com.movie.bestrelases.home.movies.presentation.uimodels.MovieUIModel


fun List<Results>.mapToUIModel(): MutableList<MovieUIModel> {
    val uiModels = mutableListOf<MovieUIModel>()
    forEach {
        uiModels.add(it.mapToUIModel())
    }
    return uiModels
}

fun Results.mapToUIModel(): MovieUIModel {
    return MovieUIModel(id,title,release_date,vote_average,overview,poster_path)
}