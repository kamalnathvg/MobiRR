package org.kamalnathvg.mobirr.radarr.presentation.movie_add

import MovieSearchBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import org.kamalnathvg.mobirr.radarr.presentation.component.MovieListItem
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.koin.compose.viewmodel.koinViewModel


@Composable
internal fun MovieAddRoot(
    viewModel: MovieAddViewModel = koinViewModel<MovieAddViewModel>(),
    bottomNavBar: @Composable (() -> Unit),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    MovieAddScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is MovieAddAction.SearchQueryChanged -> {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(0)
                    }
                }
                else -> {

                }
            }
            viewModel.onAction(action)
        },
        lazyListState = lazyListState,
        bottomNavBar = bottomNavBar
    )
}


@Composable
internal fun MovieAddScreen(
    state: MovieAddScreenState,
    onAction: (MovieAddAction) -> Unit,
    lazyListState: LazyListState,
    bottomNavBar: @Composable () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    fun clearFocusAndHideKeyboard() {
        keyboardController?.hide()
        focusManager.clearFocus()
    }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Scaffold(
        bottomBar = bottomNavBar,
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 12.dp)
        ) {
            MovieSearchBar(
                searchQuery = state.searchQuery,
                focusRequester = focusRequester,
                onSearchQueryChange = {
                    onAction(MovieAddAction.SearchQueryChanged(it))
                },
                onImeSearch = {
                    onAction(MovieAddAction.SearchMovie(it))
                },
                onFocusChanged = {
                    clearFocusAndHideKeyboard()
                }
            )

            if (state.searchResult == null && state.errorMessage != null) {
                Text(state.errorMessage)
            } else if (state.searchResult != null) {
                var expandedMovieId by remember { mutableStateOf<Int?>(null) }
                LazyColumn(
                    state = lazyListState,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    items(
                        items = state.searchResult,
                        key = { it.tmdbId }
                    ) { movie ->
                        MovieSearchResultItem(
                            movie = movie,
                            isExpanded = expandedMovieId == movie.tmdbId,
                            onClick = {
                                expandedMovieId =
                                    if (expandedMovieId == movie.tmdbId) null else movie.tmdbId
                            },
                            onAddMovie = {
                                onAction(MovieAddAction.AddMovie(movie.tmdbId))
                            }
                        )
                    }
                }
            }
        }
    }
}


@Composable
internal fun MovieSearchResultItem(
    movie: Movie,
    isExpanded: Boolean,
    onClick: () -> Unit,
    onAddMovie: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(if (isExpanded) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent)
            .padding(if (isExpanded) 4.dp else 0.dp)
    ) {
        MovieListItem(
            movie = movie,
            onMovieClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
        )
        if (isExpanded) {
            Button(
                onClick = onAddMovie,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Add Movie to Radarr")
            }
        }
    }
}


