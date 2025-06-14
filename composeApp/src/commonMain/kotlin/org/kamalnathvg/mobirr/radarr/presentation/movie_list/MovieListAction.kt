package org.kamalnathvg.mobirr.radarr.presentation.movie_list

internal sealed class MovieListAction {
    data class OnMovieClick(val movie: Movie): MovieListAction()
    data class OnSearchQueryChange(val query: String): MovieListAction()
}