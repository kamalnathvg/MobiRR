package org.kamalnathvg.mobirr.radarr.presentation.movie_add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.kamalnathvg.mobirr.radarr.domain.AddMovieUseCase
import org.kamalnathvg.mobirr.radarr.domain.LookUpMovieUseCase
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie

private const val TAG = "MovieAddViewModel"

internal data class MovieAddScreenState(
    val searchQuery: String = "",
    val searchResult: List<Movie>? = null,
    val errorMessage: String? = null
)

internal class MovieAddViewModel(
    private val addMovieUseCase: AddMovieUseCase,
    private val lookUpMovieUseCase: LookUpMovieUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MovieAddScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: MovieAddAction) {
        Logger.d(TAG) { action::class.qualifiedName.toString() }
        when (action) {
            is MovieAddAction.AddMovie -> {
                viewModelScope.launch {
                    val result: Result<Unit> = addMovieUseCase(action.movieId)
                    result
                        .onSuccess {

                        }
                        .onFailure {

                        }
                }
            }

            is MovieAddAction.SearchMovie -> {
                viewModelScope.launch {
                    val result: Result<List<Movie>> =
                        lookUpMovieUseCase(searchTerm = action.searchQuery)
                    result
                        .onSuccess { movies ->
                            _state
                                .update {
                                    it.copy(
                                        searchResult = movies
                                    )
                                }
                        }
                        .onFailure { error ->
                            _state.update {
                                it.copy(
                                    errorMessage = error.message
                                )
                            }
                        }
                }
            }

            is MovieAddAction.SearchQueryChanged -> {
                _state.update {
                    it.copy(
                        searchQuery = action.searchQuery
                    )
                }
            }
        }
    }
}