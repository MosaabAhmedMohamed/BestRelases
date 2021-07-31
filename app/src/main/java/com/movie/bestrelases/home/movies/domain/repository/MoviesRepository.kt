package com.movie.bestrelases.home.movies.domain.repository

import androidx.paging.Pager
import com.movie.bestrelases.home.movies.data.remote.model.Results

interface MoviesRepository {

    fun getMoviesPager(): Pager<Int, Results>
}