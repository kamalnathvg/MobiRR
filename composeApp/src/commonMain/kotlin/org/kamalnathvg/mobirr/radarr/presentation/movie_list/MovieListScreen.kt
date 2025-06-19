package org.kamalnathvg.mobirr.radarr.presentation.movie_list

import MovieSearchBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ViewList
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.touchlab.kermit.Logger
import kotlinx.coroutines.launch
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.component.FilterLabelSection
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.component.MovieGridView
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.component.MovieListView
import org.koin.compose.viewmodel.koinViewModel

private const val ROOT_TAG = "MovieListRoot"
private const val SCREEN_TAG = "MovieListScreen"

@Composable
internal fun MovieListRoot(
    viewModel: MovieListViewModel = koinViewModel<MovieListViewModel>(),
    onMovieClick: (Movie) -> Unit,
    bottomNavBar: @Composable () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lazyGridState = rememberLazyGridState()
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Logger.d(ROOT_TAG) { "$ROOT_TAG Re-Rendered" }
    MovieListScreen(
        state = state,
        lazyGridState = lazyGridState,
        lazyListState = lazyListState,
        onAction = { action ->
            when (action) {
                is MovieListAction.OnMovieClick -> onMovieClick(action.movie)
                is MovieListAction.OnFilterChange, is MovieListAction.OnSortValueChanged, is MovieListAction.OnSortOrderChanged -> {
                    coroutineScope.launch {
                        when (state.currentView) {
                            MovieListScreenView.LIST -> {
                                lazyListState.animateScrollToItem(0)
                            }

                            MovieListScreenView.GRID -> {
                                lazyGridState.animateScrollToItem(0)
                            }
                        }
                    }

                }

                else -> Unit
            }
            viewModel.onAction(action)
        },
        bottomNavBar = bottomNavBar,
    )
}

@Composable
internal fun MovieListScreen(
    state: MovieListScreenState,
    onAction: (MovieListAction) -> Unit,
    lazyGridState: LazyGridState,
    lazyListState: LazyListState,
    bottomNavBar: @Composable () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    fun clearFocusAndHideKeyboard() {
        keyboardController?.hide()
        focusManager.clearFocus()
    }
    Scaffold(
        bottomBar = bottomNavBar
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, bottom = 8.dp)
                .padding(paddingValues)
        ) {
            Logger.d(SCREEN_TAG) { "Movies Count: ${state.filteredMovies?.size}" }
            MovieSearchBar(
                searchQuery = state.searchQuery,
                onSearchQueryChange = { query ->
                    onAction(MovieListAction.OnSearchQueryChange(query))
                }, onImeSearch = {
                    clearFocusAndHideKeyboard()
                }, onFocusChanged = {
                    clearFocusAndHideKeyboard()
                }
            )
            FilterLabelSection(
                onFilterChanged = {
                    onAction(MovieListAction.OnFilterChange(it))
                }, currentFilterType = state.currentFilterType
            )
            SortSection(
                onAction = onAction, state = state
            )
            Box(
                modifier = Modifier.fillMaxHeight()
            ) {
                when (val result = state.filteredMovies) {
                    null -> CircularProgressIndicator()
                    else -> {
                        if (result.isNotEmpty()) {
                            when (state.currentView) {
                                MovieListScreenView.LIST -> {
                                    Logger.d(SCREEN_TAG) { "RE-RENDERING LAZY LIST" }
                                    MovieListView(
                                        lazyListState = lazyListState,
                                        movies = result,
                                        onAction = onAction
                                    )
                                }

                                MovieListScreenView.GRID -> {
                                    Logger.d(SCREEN_TAG) { "RE-RENDERING LAZY VERTICAL GRID" }
                                    MovieGridView(
                                        lazyGridState = lazyGridState,
                                        movies = result,
                                        onAction = onAction
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
}

@Composable
internal fun SortSection(
    onAction: (MovieListAction) -> Unit,
    state: MovieListScreenState,
) {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    Row {
        IconButton(
            onClick = {
                val selectedSortOrder =
                    if (state.currentSortOrder == SortOrder.DESCENDING) SortOrder.ASCENDING else SortOrder.DESCENDING
                onAction(MovieListAction.OnSortOrderChanged(selectedSortOrder))
            }) {
            Icon(
                imageVector = Icons.Default.SwapVert,
                tint = if (state.currentSortOrder == SortOrder.ASCENDING) MaterialTheme.colorScheme.primary else Color.Gray,
                contentDescription = null
            )
        }
        TextButton(
            onClick = { isDropDownMenuExpanded = !isDropDownMenuExpanded },
            content = { Text(state.currentSortValue.label) })
        DropdownMenu(
            expanded = isDropDownMenuExpanded, onDismissRequest = {
                isDropDownMenuExpanded = false
            }) {
            SortValue.entries.filter { it != state.currentSortValue }.forEach { sortValue ->
                DropdownMenuItem(text = {
                    Text(sortValue.label)
                }, onClick = {
                    isDropDownMenuExpanded = false
                    onAction(MovieListAction.OnSortValueChanged(sortValue))
                })
            }
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
        IconButton(
            onClick = {
                val updatedView =
                    if (state.currentView == MovieListScreenView.LIST) MovieListScreenView.GRID else MovieListScreenView.LIST
                onAction(MovieListAction.OnListViewChange(updatedView))
            }) {
            Icon(

                imageVector = if (state.currentView == MovieListScreenView.LIST) Icons.Filled.Apps
                else Icons.AutoMirrored.Default.ViewList, contentDescription = null
            )
        }
    }
}