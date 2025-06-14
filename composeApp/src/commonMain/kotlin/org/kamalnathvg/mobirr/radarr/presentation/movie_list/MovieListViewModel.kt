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



private const val TAG = "MovieListScreenViewModel"

internal data class MovieListScreenState(
    val filteredMovies: List<Movie>? = null,
    val errorMessage: String? = null,
    val searchQuery: String = "",
)


internal class MovieListViewModel(): ViewModel(){
    private var cachedMovies: List<Movie>? = null

    private val _state = MutableStateFlow(MovieListScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            fetchMovies()
        }
    }

    private suspend fun fetchMovies(){
        Logger.d("Trying to fetch movies", tag = TAG)

        cachedMovies = getDummyMovies()
        _state.update {
            it.copy(
                filteredMovies = cachedMovies
            )
        }
        Logger.d(TAG) { "Movies after updating ${state.value.filteredMovies?.size}" }
    }

    fun onAction(action: MovieListAction){
        Logger.d(TAG){action::class.qualifiedName.toString()}
        when(action){
            is MovieListAction.OnMovieClick -> {

            }

            is MovieListAction.OnSearchQueryChange -> {
                val filteredMovies = cachedMovies?.filter {
                    it.title.toLowerCase(Locale.current).contains(action.query.toLowerCase(Locale.current))
                }
                _state.update {
                    it.copy(
                        searchQuery = action.query,
                        filteredMovies = filteredMovies
                    )
                }
            }
        }
    }
}