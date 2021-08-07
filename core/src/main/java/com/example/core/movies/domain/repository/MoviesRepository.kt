package com.example.core.movies.domain.repository

import androidx.paging.Pager
import com.example.core.movies.data.remote.model.Results

interface MoviesRepository {

    fun getMoviesPager(): Pager<Int, Results>
}