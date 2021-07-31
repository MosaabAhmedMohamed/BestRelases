package com.movie.bestrelases.home.moviedetail.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.movie.bestrelases.base.presentation.BaseViewModel
import com.movie.bestrelases.home.moviedetail.domain.usecase.MovieDetailUseCase
import com.movie.bestrelases.home.moviedetail.presentation.uimodel.mapToUI
import com.movie.bestrelases.home.moviedetail.presentation.viewstate.MovieDetailViewState
import com.movie.bestrelases.home.movies.presentation.uimodels.MovieUIModel
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