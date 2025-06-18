package org.kamalnathvg.mobirr.radarr.presentation.movie_list

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.kamalnathvg.mobirr.radarr.domain.GetMoviesUseCase
import org.koin.core.component.KoinComponent


private const val TAG = "MovieListScreenViewModel"

internal data class MovieListScreenState(
    val filteredMovies: List<Movie>? = null,
    val errorMessage: String? = null,
    val searchQuery: String = "",
    val currentFilterType: FilterType = FilterType.ALL,
    val currentSortOrder: SortOrder = SortOrder.DESCENDING,
    val currentSortValue: SortValue = SortValue.TITLE,
    val currentView: MovieListScreenView = MovieListScreenView.LIST
)


internal enum class SortValue(val label: String) {
    ADDED("Added"), SIZE_ON_DISK("Size On Disk"), TITLE("Title"), RELEASE_DATE("Release Date"),
}

internal enum class SortOrder {
    ASCENDING, DESCENDING
}

internal enum class FilterType(val label: String) {
    ALL("All"), UNMONITORED("Unmonitored"), MONITORED("Monitored"), MISSING("Missing"), WANTED("Wanted"), CUTOFF_MET(
        "Cut-Off Met"
    )
}


enum class MovieListScreenView {
    LIST, GRID
}

internal class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel(), KoinComponent {
    private var cachedMovies: List<Movie>? = null

    private val _state = MutableStateFlow(MovieListScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            fetchMovies()
        }
    }

    private suspend fun fetchMovies() {
        Logger.d("Trying to fetch movies", tag = TAG)

        getMoviesUseCase.invoke().fold(onSuccess = {
            cachedMovies = it
        }, onFailure = { error ->
            _state.update {
                it.copy(
                    errorMessage = error.message
                )
            }
        })

        _state.update {
            it.copy(
                filteredMovies = cachedMovies
            )
        }
        Logger.d(TAG) { "Movies after updating ${state.value.filteredMovies?.size}" }
    }

    fun onAction(action: MovieListAction) {
        Logger.d(TAG) { action::class.qualifiedName.toString() }
        when (action) {
            is MovieListAction.OnMovieClick -> {

            }

            is MovieListAction.OnSearchQueryChange -> {
                val filteredMovies = cachedMovies?.filter {
                    it.title.toLowerCase(Locale.current)
                        .contains(action.query.toLowerCase(Locale.current))
                }
                _state.update {
                    it.copy(
                        searchQuery = action.query, filteredMovies = filteredMovies
                    )
                }
            }

            is MovieListAction.OnFilterChange -> {
                handleFilterChange(filterType = action.filterType)
            }

            is MovieListAction.OnSortOrderChanged -> {
                val filteredMovies = state.value.filteredMovies?.handleSortOrderChanged(
                    sortOrder = action.sortOrder, sortValue = state.value.currentSortValue
                ) ?: emptyList<Movie>()
                _state.update {
                    it.copy(
                        currentSortOrder = action.sortOrder, filteredMovies = filteredMovies
                    )
                }
            }

            is MovieListAction.OnSortValueChanged -> {
                val filteredMovies = state.value.filteredMovies?.handleSortOrderChanged(
                    sortOrder = state.value.currentSortOrder, sortValue = action.sortValue
                ) ?: emptyList<Movie>()
                _state.update {
                    it.copy(
                        currentSortValue = action.sortValue, filteredMovies = filteredMovies
                    )
                }
            }

            is MovieListAction.OnListViewChange -> {
                _state.update {
                    it.copy(
                        currentView = action.movieListScreenView
                    )
                }
            }
        }
    }

    private fun List<Movie>.handleSortOrderChanged(
        sortOrder: SortOrder, sortValue: SortValue
    ): List<Movie> {
        return when (sortValue) {
            SortValue.ADDED -> {
                this.sortByOrder(sortOrder) { it.added }
            }

            SortValue.SIZE_ON_DISK -> this.sortByOrder(sortOrder) { it.sizeOnDisk }
            SortValue.TITLE -> this.sortByOrder(sortOrder) { it.title }
            SortValue.RELEASE_DATE -> this.sortByOrder(sortOrder) { it.year }
        }
    }

    private fun <T, R : Comparable<R>> List<T>.sortByOrder(
        sortOrder: SortOrder, selector: (T) -> R?
    ) = when (sortOrder) {
        SortOrder.ASCENDING -> this.sortedBy(selector)
        SortOrder.DESCENDING -> this.sortedByDescending(selector)
    }

    private fun handleFilterChange(filterType: FilterType) {
        viewModelScope.launch {
            val filteredMovies = cachedMovies?.getFilteredMovie(filterType)
            _state.update {
                it.copy(
                    filteredMovies = filteredMovies, currentFilterType = filterType
                )
            }
        }
    }

    private fun List<Movie>.getFilteredMovie(filterType: FilterType): List<Movie> {
        return when (filterType) {
            FilterType.ALL -> {
                this
            }

            FilterType.UNMONITORED -> {
                this.filter {
                    !it.isMonitored
                }
            }

            FilterType.MONITORED -> {
                this.filter {
                    it.isMonitored
                }
            }

            FilterType.MISSING -> {
                this.filter {
                    !it.hasFile
                }
            }

            FilterType.WANTED -> {
                this.filter {
                    !it.hasFile && it.isMonitored
                }
            }

            FilterType.CUTOFF_MET -> {
                this.filter {
                    it.isCutOffMet
                }
            }
        }
    }
}