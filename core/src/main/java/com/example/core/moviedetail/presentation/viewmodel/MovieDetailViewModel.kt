package com.example.core.moviedetail.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.core.base.presentation.BaseViewModel
import com.example.core.moviedetail.domain.usecase.MovieDetailUseCase
import com.example.core.moviedetail.presentation.uimodel.mapToUI
import com.example.core.moviedetail.presentation.viewstate.MovieDetailViewState
import com.example.core.movies.presentation.uimodels.MovieUIModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) :
    BaseViewModel() {

    var movieUIModel: MovieUIModel? = null
    var movieId: Int = 0

    val movieDetailLV by lazy { MutableLiveData<MovieDetailViewState>() }

    fun getMovieDetail(id: Int) {
        movieDetailUseCase.getMovie(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                movieDetailLV.value = MovieDetailViewState.onError(it)
            }
            .doOnSubscribe {
                movieDetailLV.value = MovieDetailViewState.Loading
            }
            .subscribe { movieResponse ->
                movieDetailLV.value = MovieDetailViewState.onSuccess(movieResponse.mapToUI())
            }.addTo(compositeDisposable)
    }
}