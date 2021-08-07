package com.example.core.movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.core.base.presentation.BaseViewModel
import com.example.core.movies.data.remote.model.Results
import com.example.core.movies.domain.usecase.MoviesUseCase
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase) : BaseViewModel() {

    private var movies: Pager<Int, Results>? = null


    fun moviesList(): LiveData<PagingData<Results>> {
        if (movies == null) movies = moviesUseCase.getMoviesPager()
        return movies!!.liveData
    }



}