package org.kamalnathvg.mobirr.radarr.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListRoot
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListScreen

internal fun NavGraphBuilder.radarrRoute(){
    composable<MovieList> {
        MovieListRoot(
            onMovieClick = {
                // TODO: Navigate to Movie Details Page
            }
        )
    }
}


@Serializable
object MovieList