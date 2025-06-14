package org.kamalnathvg.mobirr.radarr.presentation.movie_list

import MovieSearchBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.touchlab.kermit.Logger
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.component.MovieGridItem
import org.koin.compose.viewmodel.koinViewModel

private const val ROOT_TAG = "MovieListRoot"
private const val SCREEN_TAG = "MovieListScreen"

@Composable
internal fun MovieListRoot(
    viewModel: MovieListViewModel = koinViewModel<MovieListViewModel>(),
    onMovieClick: (Movie) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Logger.d(ROOT_TAG) { "$ROOT_TAG Re-Rendered" }
    MovieListScreen(
        state = state, onAction = { action ->
            when (action) {
                is MovieListAction.OnMovieClick -> onMovieClick(action.movie)
                else -> Unit
            }
            viewModel.onAction(action)
        })
}

@Composable
internal fun MovieListScreen(
    state: MovieListScreenState, onAction: (MovieListAction) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    fun clearFocusAndHideKeyboard() {
        keyboardController?.hide()
        focusManager.clearFocus()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .statusBarsPadding()
    ) {
        Logger.d(SCREEN_TAG) { "Movies Count: ${state.filteredMovies?.size}" }
        MovieSearchBar(
            searchQuery = state.searchQuery,
            onSearchQueryChange = { query ->
                onAction(MovieListAction.OnSearchQueryChange(query))
            },
            onImeSearch = {
                clearFocusAndHideKeyboard()
            },
            onFocusChanged = {
                clearFocusAndHideKeyboard()
            }
        )

        Box(
            modifier = Modifier.fillMaxHeight()
        ) {
            when (val result = state.filteredMovies) {
                null -> CircularProgressIndicator()
                else -> {
                    if (result.isNotEmpty()) {
                        Logger.d(SCREEN_TAG) { "RE-RENDERING LAZY VERTICAL GRID" }
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(minSize = 128.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            items(
                                items = result, key = { it.id }) { movie ->
                                MovieGridItem(
                                    movie = movie,
                                    onMovieClick = {
                                        onAction(MovieListAction.OnMovieClick(movie))
                                    },
                                )
                            }
                        }
                    } else {
                        Text("No Movies Found")
                    }
                }
            }
        }
    }
}


