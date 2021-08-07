package com.movie.bestrelases.home.movies.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.base.di.ViewModelFactory
import com.example.core.movies.presentation.uimodels.MovieUIModel
import com.example.core.movies.presentation.viewmodel.MoviesViewModel
import com.movie.bestrelases.R
import com.movie.bestrelases.base.ui.BaseFragment
import com.movie.bestrelases.base.ui.ext.navigate
import com.movie.bestrelases.base.ui.ext.showLoading
import com.movie.bestrelases.base.ui.ext.showRetryDialog
import com.movie.bestrelases.databinding.FragmentMoviesBinding
import com.movie.bestrelases.home.movies.ui.adapter.HeaderFooterAdapter
import com.movie.bestrelases.home.movies.ui.adapter.MoviesAdapter
import com.movie.bestrelases.util.ui.NavigationConst.Companion.MODEL_KEY
import javax.inject.Inject

class MoviesFragment : BaseFragment() {

    private lateinit var binding: FragmentMoviesBinding

    @Inject
    lateinit var moviesViewModelFactory: ViewModelFactory<MoviesViewModel>
    private val moviesViewModel by lazy {
        ViewModelProvider(this, moviesViewModelFactory).get(MoviesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }


    private lateinit var adapter: MoviesAdapter

    override fun init() {
        if (!this::adapter.isInitialized) {
            adapter = MoviesAdapter(
                { selectedItem ->
                    navigateToMovieDetail(selectedItem)
                },
                DIFF_CALLBACK = MoviesAdapter.DIFF_CALLBACK
            )
        }
        initMoviesRv()
        initMoviesListObserver()
    }

    private fun navigateToMovieDetail(movieUIModel: MovieUIModel) {
        Bundle().apply {
            putParcelable(MODEL_KEY, movieUIModel)
            navigate(R.id.action_moviesFragment_to_movieDetailFragment,this)
        }
    }

    private fun initMoviesRv() {

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = GridLayoutManager(context, 3)
        binding.rv.adapter = adapter.withLoadStateHeaderAndFooter(
            header = HeaderFooterAdapter(adapter),
            footer = HeaderFooterAdapter(adapter)
        )
        adapter.addLoadStateListener {
             showLoading(it.refresh is LoadState.Loading)
             showRetryDialog(it.refresh is LoadState.Error) {
                 adapter.retry()
             }
        }

        binding.refreshLayout.setOnRefreshListener { adapter.refresh() }
    }



    private fun initMoviesListObserver() {
        if (adapter.itemCount == 0)
            moviesViewModel.moviesList().observe(requireActivity(), {
                binding.refreshLayout.stopRefresh()
                adapter.submitData(lifecycle, it)
            })
    }
}