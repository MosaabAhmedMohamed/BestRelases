package com.movie.bestrelases.home.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.movie.bestrelases.home.movies.data.remote.client.MoviesApi
import com.movie.bestrelases.home.movies.data.remote.model.Results
import com.movie.bestrelases.home.movies.data.repository.datasource.MoviesDataSource
import com.movie.bestrelases.home.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val api: MoviesApi) : MoviesRepository {


    override fun getMoviesPager(): Pager<Int, Results> {
        return Pager(PagingConfig( /* pageSize = */15, enablePlaceholders = false),
            pagingSourceFactory = { MoviesDataSource(api) })
    }
}