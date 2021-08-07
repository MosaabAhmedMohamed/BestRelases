package com.example.core.moviedetail.data.remote.model

data class MovieDetailModel(
    val adult: Boolean?,
    val backdropPath: String?,
    val belongsToCollection: Any?,
    val budget: Int?,
    val genres: List<Genre>?,
    val homepage: String?,
    val id: Int?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val productionCompanies: List<ProductionCompany>?,
    val productionCountries: List<ProductionCountry>?,
    val release_date: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spokenLanguages: List<SpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val voteCount: Int?
)