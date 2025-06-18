package org.kamalnathvg.mobirr.previews.movie_list

import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.compose.MobiRRTheme
import org.kamalnathvg.mobirr.app.navigation.AppBottomNavBar
import org.kamalnathvg.mobirr.previews.movie_details.getMovies
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListScreen
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListScreenState

@Preview
@Composable
private fun MovieListScreenPreview() {
    val state = MovieListScreenState(
        filteredMovies = getMovies(),
        errorMessage = null,
        searchQuery = ""
    )
    MobiRRTheme {
        MovieListScreen(
            state = state,
            onAction = {},
            lazyGridState = rememberLazyGridState(),
            lazyListState = rememberLazyListState(),
            bottomNavBar = { AppBottomNavBar(rememberNavController())}
        )
    }
}