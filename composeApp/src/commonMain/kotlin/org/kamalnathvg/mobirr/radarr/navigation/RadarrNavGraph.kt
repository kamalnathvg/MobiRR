package org.kamalnathvg.mobirr.radarr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsRoot
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListRoot

fun NavGraphBuilder.radarrGraph(
    navController: NavHostController,
    bottomNavBar: @Composable () -> Unit,
){
    navigation<RadarrGraph>(
        startDestination = RadarrGraph.MovieList
    ) {
        composable<RadarrGraph.MovieList> {
            MovieListRoot(
                onMovieClick = { movie ->
                    navController.navigate(RadarrGraph.MovieDetails(movie.tmdbId))
                },
                bottomNavBar = bottomNavBar
            )
        }
        composable<RadarrGraph.MovieDetails> { backStackEntry ->
            val movieDetails = backStackEntry.toRoute<RadarrGraph.MovieDetails>()
            MovieDetailsRoot(
                onNavigateBack = {navController.navigateUp()},
                movieId = movieDetails.movieId
            )
        }
    }
}

@Serializable
internal object RadarrGraph {
    @Serializable
    object MovieList

    @Serializable
    data class MovieDetails(val movieId: Int)
}