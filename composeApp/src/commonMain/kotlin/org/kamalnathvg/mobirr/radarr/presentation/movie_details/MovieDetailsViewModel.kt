package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.getDummyMovieById
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.getDummyMovies

internal data class MovieDetailsScreenState(
    val movie: Movie? = null,
    val errorMessage: String? = null,
)

internal class MovieDetailsViewModel(): ViewModel() {

    private val _state = MutableStateFlow(MovieDetailsScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: MovieDetailsAction){
        when(action){
            is MovieDetailsAction.GetMovieDetails -> {
                viewModelScope.launch {
                    val result = getDummyMovieById(action.movieId)
                    result
                        .onFailure { error ->
                            _state.update {
                                it.copy(
                                    errorMessage = error.message
                                )
                            }
                        }
                        .onSuccess { movie ->
                            _state.update {
                                it.copy(
                                    movie = movie
                                )
                            }
                        }
                }
            }
        }
    }
}