package com.movie.bestrelases.home.moviedetail.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.movie.bestrelases.R
import com.movie.bestrelases.base.ui.BaseFragment
import com.movie.bestrelases.base.ui.ext.gone
import com.movie.bestrelases.base.ui.ext.showLoading
import com.movie.bestrelases.base.ui.ext.showRetryDialog
import com.movie.bestrelases.base.ui.ext.visible
import com.movie.bestrelases.databinding.FragmentMovieDetailBinding
import com.movie.bestrelases.di.ViewModelFactory
import com.movie.bestrelases.home.moviedetail.data.remote.model.MovieDetailModel
import com.movie.bestrelases.home.moviedetail.presentation.viewmodel.MovieDetailViewModel
import com.movie.bestrelases.home.moviedetail.presentation.viewstate.MovieDetailViewState
import com.movie.bestrelases.util.data.APIConst.Companion.ID_KEY
import com.movie.bestrelases.util.data.APIConst.Companion.POSTER_BASE_URL
import javax.inject.Inject

class MovieDetailFragment() : BaseFragment() {

    private lateinit var binding: FragmentMovieDetailBinding


    @Inject
    lateinit var movieDetailVMFactory: ViewModelFactory<MovieDetailViewModel>
    private val movieDetailViewModel by lazy {
        ViewModelProvider(this, movieDetailVMFactory).get(MovieDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.rootView
    }


    override fun init() {
        initMovieObserver()
        checkArgs()
    }

    private fun checkArgs() {
        if (arguments != null && requireArguments().containsKey(ID_KEY)) {
            movieDetailViewModel.movieId = requireArguments().getInt(ID_KEY)
            getMovie(requireArguments().getInt(ID_KEY))
        }
    }

    private fun getMovie(movieId: Int = movieDetailViewModel.movieId) {
        movieDetailViewModel.getMovieDetail(movieId)
    }

    private fun initMovieObserver() {
        movieDetailViewModel.movieDetailLV.observe(
            viewLifecycleOwner,
            {
                it?.let {
                    handleMovieDetailViewState(it)
                }
            })
    }

    private fun handleMovieDetailViewState(viewState: MovieDetailViewState) {
        when (viewState) {
            MovieDetailViewState.Loading -> loadingState()
            is MovieDetailViewState.onError -> errorState(viewState.error)
            is MovieDetailViewState.onSuccess -> successState(viewState.result)
        }
    }

    private fun successState(result: MovieDetailModel) {
        binding.rootView.visible()
        showLoading(false)
        setData(result)
    }

    private fun errorState(error: Throwable) {
        showRetryDialog(true) {
            getMovie()
        }
        showLoading(false)
    }

    private fun loadingState() {
        binding.rootView.gone()
        showLoading(true)
    }


    private fun setData(model: MovieDetailModel) {
        binding.movieTitle.text = model.title
        binding.movieReleaseDate.text = model.release_date
        binding.movieRating.text = model.vote_average.toString()
        binding.movieOverview.text = model.overview
        binding.ivMoviePoster.load(POSTER_BASE_URL.plus(model.poster_path)) {
            crossfade(true)
                .error(R.drawable.ic_movie)
                .placeholder(R.drawable.ic_movie)
                .scale(Scale.FILL)
            transformations(RoundedCornersTransformation())
        }
    }
}