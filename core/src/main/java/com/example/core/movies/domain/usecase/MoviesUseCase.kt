package com.example.core.movies.domain.usecase

import androidx.paging.Pager
import com.example.core.movies.data.remote.model.Results
import com.example.core.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    fun getMoviesPager(): Pager<Int, Results> {
        return repository.getMoviesPager()
    }
}