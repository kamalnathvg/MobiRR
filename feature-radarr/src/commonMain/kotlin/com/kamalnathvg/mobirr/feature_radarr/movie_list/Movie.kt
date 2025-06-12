package com.kamalnathvg.mobirr.feature_radarr.movie_list

import kotlinx.datetime.LocalDateTime

internal data class Movie(
    val id: String,
    val title: String,
    val year: Int,
    val studio: String,
    val hasFile: Boolean,
    val isAvailable: Boolean,
    val imdbId: String,
    val tmdbId: Int,
    val overView: String,
    val added: LocalDateTime,
    val images: List<Image>,
    val genres: List<Genre>
){
    data class Image(
        val coverType: CoverType,
        val localUrl: String,
        val remoteUrl: String
    )
}



internal enum class CoverType{
    POSTER,
    FAN_ART
}

internal enum class Genre{
    COMEDY,
    DRAMA
}