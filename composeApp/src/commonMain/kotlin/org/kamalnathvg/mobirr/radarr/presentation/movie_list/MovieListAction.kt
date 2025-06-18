package org.kamalnathvg.mobirr.radarr.presentation.movie_list

internal sealed class MovieListAction {
    data class OnMovieClick(val movie: Movie): MovieListAction()
    data class OnSearchQueryChange(val query: String): MovieListAction()
    data class OnFilterChange(val filterType: FilterType): MovieListAction()
    data class OnSortValueChanged(val sortValue: SortValue): MovieListAction()
    data class OnSortOrderChanged(val sortOrder: SortOrder): MovieListAction()
    data class OnListViewChange(val movieListScreenView: MovieListScreenView): MovieListAction()
}