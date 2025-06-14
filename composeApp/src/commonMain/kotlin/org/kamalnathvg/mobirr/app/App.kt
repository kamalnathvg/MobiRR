package org.kamalnathvg.mobirr.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListRoot
import org.koin.compose.KoinContext

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            MovieListRoot(
                onMovieClick = {})
        }
    }
}