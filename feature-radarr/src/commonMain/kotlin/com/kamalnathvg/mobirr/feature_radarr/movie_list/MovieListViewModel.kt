package com.kamalnathvg.mobirr.feature_radarr.movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal data class MovieListScreenState(
    val movies: List<Movie>? = null,
    val errorMessage: String? = null,
)


internal class MovieListViewModel(): ViewModel(){

    private val _state = MutableStateFlow(MovieListScreenState())
    val state = _state.asStateFlow()

    init {
        fetchMovies()
    }

    private fun fetchMovies(){
        //TODO: fetch movies from api
    }

    fun onAction(action: MovieListAction){
        when(action){
            is MovieListAction.onMovieClick -> {
                //
            }
        }
    }
}