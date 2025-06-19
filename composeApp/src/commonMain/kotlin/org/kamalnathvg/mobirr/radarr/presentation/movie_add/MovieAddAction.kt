package org.kamalnathvg.mobirr.radarr.presentation.movie_add

internal sealed class MovieAddAction {
    data class SearchMovie(val searchQuery: String): MovieAddAction()
    data class SearchQueryChanged(val searchQuery: String): MovieAddAction()
    data class AddMovie(val movieId: Int): MovieAddAction()
}