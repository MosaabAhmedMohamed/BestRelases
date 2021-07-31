package com.movie.bestrelases.home.movies.ui.adapter

import android.view.View
import coil.load
import coil.transform.RoundedCornersTransformation
import com.movie.bestrelases.R
import com.movie.bestrelases.base.ui.BaseViewHolder
import com.movie.bestrelases.databinding.ItemMovieBinding
import com.movie.bestrelases.home.movies.data.remote.model.Results
import com.movie.bestrelases.util.FirebaseAnalyticsUtil
import com.movie.bestrelases.util.data.APIConst.Companion.POSTER_BASE_URL


class MovieItemVH(
    itemView: View,
    val itemClick: (Int) -> Unit
) : BaseViewHolder<Results>(itemView) {


    private val binding = ItemMovieBinding.bind(itemView)

    override fun onBind(item: Results) {
        try {
            binding.cvIvMoviePoster.load(POSTER_BASE_URL.plus(item.poster_path)) {
                crossfade(true)
                    .error(R.drawable.ic_movie)
                    .placeholder(R.drawable.ic_movie)
                transformations(RoundedCornersTransformation(10F))
            }
            binding.cvMovieReleaseDate.text = item.release_date
            binding.cvMovieTitle.text = item.title
            binding.cardView.setOnClickListener {
                FirebaseAnalyticsUtil.logMovieDetailEvent(item.id, item.original_title)
                itemClick(item.id)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

}