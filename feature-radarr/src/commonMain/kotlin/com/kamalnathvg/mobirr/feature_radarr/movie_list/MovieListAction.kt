package com.kamalnathvg.mobirr.feature_radarr.movie_list

internal sealed class MovieListAction {
    data class onMovieClick(val movie: Movie): MovieListAction()

}