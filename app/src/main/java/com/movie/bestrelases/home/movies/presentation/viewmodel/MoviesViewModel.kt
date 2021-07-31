package com.movie.bestrelases.home.movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.liveData
import com.movie.bestrelases.base.presentation.BaseViewModel
import com.movie.bestrelases.home.movies.data.remote.model.Results
import com.movie.bestrelases.home.movies.domain.usecase.MoviesUseCase
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase) : BaseViewModel() {

    private var movies: Pager<Int, Results>? = null


    fun moviesList(): LiveData<PagingData<Results>> {
        if (movies == null) movies = moviesUseCase.getMoviesPager()
        return movies!!.liveData
    }



}