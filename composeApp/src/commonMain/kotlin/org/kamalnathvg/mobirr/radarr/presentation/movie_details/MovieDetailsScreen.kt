package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun MovieDetailsRoot(
    viewModel: MovieDetailsViewModel = koinViewModel(),
    onBackClick: () -> Unit,
    movieId: Int
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(movieId) {
        viewModel.onAction(MovieDetailsAction.GetMovieDetails(movieId))
    }
    MovieDetailsScreen(
        state = state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}

@Composable
internal fun MovieDetailsScreen(
    state: MovieDetailsScreenState,
    onAction: (MovieDetailsAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when(state.movie){
            null -> CircularProgressIndicator()
            else -> {
                Text("Showing Details of Movie: ${state.movie.title}")
            }
        }
    }
}