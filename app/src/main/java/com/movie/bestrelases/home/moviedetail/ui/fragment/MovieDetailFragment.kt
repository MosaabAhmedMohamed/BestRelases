package com.movie.bestrelases.home.moviedetail.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.example.core.base.di.ViewModelFactory
import com.example.core.moviedetail.presentation.viewmodel.MovieDetailViewModel
import com.example.core.moviedetail.presentation.viewstate.MovieDetailViewState
import com.example.core.movies.presentation.uimodels.MovieUIModel
import com.example.core.util.data.APIConst.Companion.POSTER_BASE_URL
import com.movie.bestrelases.R
import com.movie.bestrelases.base.ui.BaseFragment
import com.movie.bestrelases.base.ui.ext.gone
import com.movie.bestrelases.base.ui.ext.showLoading
import com.movie.bestrelases.base.ui.ext.showRetryDialog
import com.movie.bestrelases.base.ui.ext.visible
import com.movie.bestrelases.databinding.FragmentMovieDetailBinding
import com.movie.bestrelases.util.ui.NavigationConst.Companion.ID_KEY
import com.movie.bestrelases.util.ui.NavigationConst.Companion.MODEL_KEY
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
        if (arguments != null) {
            if (requireArguments().containsKey(ID_KEY)) {
                movieDetailViewModel.movieId = requireArguments().getInt(ID_KEY)
                getMovie(requireArguments().getInt(ID_KEY))
            } else if (requireArguments().containsKey(MODEL_KEY)) {
                movieDetailViewModel.movieUIModel =
                    requireArguments().getParcelable(MODEL_KEY)
                setData()
            }
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

    private fun successState(result: MovieUIModel) {
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


    private fun setData(model: MovieUIModel? = movieDetailViewModel.movieUIModel) {
        model?.let {
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
}