package com.example.core.movies.presentation.uimodels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieUIModel(
    val id: Int? = 0,
    val title: String? = null,
    val release_date: String? = null,
    var vote_average: Double?,
    val overview: String? = null,
    val poster_path: String? = null
) : Parcelable
