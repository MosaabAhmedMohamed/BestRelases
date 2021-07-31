package com.movie.bestrelases.home.movies.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.movie.bestrelases.R
import com.movie.bestrelases.home.movies.data.remote.model.Results
import com.movie.bestrelases.home.movies.presentation.uimodels.MovieUIModel

class MoviesAdapter(
    private val onItemClick: (MovieUIModel) -> Unit,
    DIFF_CALLBACK: DiffUtil.ItemCallback<Results>
) : PagingDataAdapter<Results, MovieItemVH>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieItemVH(view, onItemClick)
    }

    override fun onBindViewHolder(holderMovie: MovieItemVH, position: Int) {
        val item: Results? = getItem(position)
        // Note that item may be null. ViewHolder must support binding a
        // null item as a placeholder.
        item?.let { holderMovie.onBind(it) }
    }


    object DIFF_CALLBACK : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem == newItem
        }
    }

}