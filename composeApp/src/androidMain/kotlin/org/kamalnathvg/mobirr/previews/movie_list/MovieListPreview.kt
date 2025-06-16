package org.kamalnathvg.mobirr.previews.movie_list

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.MobiRRTheme
import org.kamalnathvg.mobirr.previews.movie_details.getMovies
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListScreen
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListScreenState

@Preview
@Composable
private fun MovieListScreenPreview() {
    val movies = getMovies()
    val state = MovieListScreenState(
        filteredMovies = getMovies(),
        errorMessage = null,
        searchQuery = ""
    )
    MobiRRTheme {
        MovieListScreen(
            state = state,
            onAction = {}
        )
    }
}