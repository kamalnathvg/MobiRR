package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import mobirr.composeapp.generated.resources.Res
import mobirr.composeapp.generated.resources.icon_movie
import org.jetbrains.compose.resources.painterResource
import org.kamalnathvg.mobirr.radarr.navigation.RadarrGraph
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun MovieDetailsRoot(
    viewModel: MovieDetailsViewModel = koinViewModel(),
    onNavigateBack: () -> Unit,
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
        },
        onNavigateBack = onNavigateBack
    )
}

@Composable
internal fun MovieDetailsScreen(
    state: MovieDetailsScreenState,
    onAction: (MovieDetailsAction) -> Unit,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when(val movieDetails = state.movieDetailsForView){
            null -> CircularProgressIndicator()
            else -> {
                MovieInfoSection(
                    movieInfo = movieDetails.movieInfo,
                    onNavigateBack = onNavigateBack
                )
                movieDetails.filesInfo.forEach { fileInfo ->
                    FilesInfoSection(
                        filesInfo = fileInfo
                    )
                }
                CastInfoSection()
                CrewInfoSection()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MovieInfoSection(
    movieInfo: MovieDetailsForView.MovieInfo,
    onNavigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ){
            AsyncImage(
                model = movieInfo.getMoviePosterOrDefault()?.remoteUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = painterResource(Res.drawable.icon_movie),
                modifier = Modifier
                    .width(132.dp)
                    .height(200.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = movieInfo.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(movieInfo.year.toString())
                    Text(movieInfo.runtime)
                }
                AssistChip(
                    onClick = {},
                    label = {Text(movieInfo.downloadStatus)}
                )
                AssistChip(
                    onClick = {},
                    label = {Text(movieInfo.qualityInfo)}
                )
            }
        }
        Text(movieInfo.description)
    }
}


@Composable
internal fun FileInfoSectionHeader(){
    Text(
        text = "Files",
        style = MaterialTheme.typography.headlineSmall
    )
}


@Composable
internal fun FilesInfoSection(
    filesInfo: MovieDetailsForView.FileInfo
){
    Card(

    ) {

    }
}


@Composable
internal fun CastInfoSection(){

}

@Composable
internal fun CrewInfoSection(){

}