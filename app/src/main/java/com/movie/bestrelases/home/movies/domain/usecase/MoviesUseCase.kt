package com.movie.bestrelases.home.movies.domain.usecase

import androidx.paging.Pager
import com.movie.bestrelases.home.movies.data.remote.model.Results
import com.movie.bestrelases.home.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    fun getMoviesPager(): Pager<Int, Results> {
        return repository.getMoviesPager()
    }
}