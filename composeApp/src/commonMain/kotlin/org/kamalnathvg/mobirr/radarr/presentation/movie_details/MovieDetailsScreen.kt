package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import mobirr.composeapp.generated.resources.Res
import mobirr.composeapp.generated.resources.demo_poster
import mobirr.composeapp.generated.resources.imdb
import mobirr.composeapp.generated.resources.tmdb
import org.jetbrains.compose.resources.painterResource
import org.kamalnathvg.mobirr.radarr.data.CreditResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.components.CreditResourceItem
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.components.ReleasesBottomSheet
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.components.getCreditItemRowCountAndWidth
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.round

private const val TAG = "MovieDetailsScreen"

@Composable
internal fun MovieDetailsRoot(
    viewModel: MovieDetailsViewModel = koinViewModel(), onNavigateBack: () -> Unit, movieId: Int
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
        onNavigateBack = onNavigateBack,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MovieDetailsScreen(
    state: MovieDetailsScreenState,
    onAction: (MovieDetailsAction) -> Unit,
    onNavigateBack: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet) {
        ReleasesBottomSheet(
            sheetState = sheetState,
            releases = state.releases,
            errorMessage = state.releasesErrorMessage,
            onAddRelease = {
                onAction(MovieDetailsAction.AddRelease(it))
            },
            onDismissRequest = {
                showBottomSheet = false
            })
    }
    Surface {
        val (creditsRowItemCount, imageWidth) = getCreditItemRowCountAndWidth()
        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp).statusBarsPadding(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            when (val movieDetails = state.movieDetailsForView) {
                null -> item { CircularProgressIndicator() }
                else -> {
                    item {
                        MovieInfoSection(
                            movieInfo = movieDetails.movieInfo,
                            onNavigateBack = onNavigateBack,
                            onSearchClick = {
                                showBottomSheet = true
                                onAction(MovieDetailsAction.GetReleases(movieDetails.id))
                            })
                    }
                    item {
                        movieDetails.filesInfo?.let { fileInfo ->
                            FilesInfoSection(
                                filesInfo = fileInfo, onDeleteButtonClick = { fileId ->
                                    onAction(MovieDetailsAction.DeleteMovieFile(fileId))
                                })
                        }
                    }
                    creditResourceSection(
                        credits = movieDetails.credits,
                        itemsInRow = creditsRowItemCount,
                        imageWidth = imageWidth
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MovieInfoSection(
    movieInfo: MovieDetailsForView.MovieInfo,
    onNavigateBack: () -> Unit,
    onSearchClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth().height(250.dp).padding(bottom = 4.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).padding(
                    vertical = 12.dp
                )
        ) {
            AsyncImage(
                model = movieInfo.getMoviePosterOrDefault()?.remoteUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = painterResource(Res.drawable.demo_poster),
                modifier = Modifier.width(150.dp).height(250.dp)
            )
            Column(
                modifier = Modifier.weight(1f).padding(start = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = movieInfo.title,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = onSearchClick,
                    ) {
                        Icon(
                            Icons.Default.Search, contentDescription = null
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        movieInfo.year.toString(),
                        modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
                    )
                    Text(movieInfo.runtime)
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 12.dp, alignment = Alignment.CenterHorizontally
                    ),
                ) {
                    Image(
                        painter = painterResource(Res.drawable.tmdb),
                        contentDescription = "tmdb",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier.height(16.dp)
                    )
                    Text(
                        text = movieInfo.tmdbRating,
                    )

                    Image(
                        painter = painterResource(Res.drawable.imdb),
                        contentDescription = "imdb",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.height(16.dp)
                    )
                    Text(
                        text = movieInfo.imdbRating
                    )
                }
                Spacer(Modifier.weight(1f))
                Row(
                    horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom
                ) {
                    AssistChip(
                        onClick = {}, label = {
                        Text(
                            movieInfo.downloadStatus,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }, modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
                    )
                    AssistChip(onClick = {}, label = {
                        Text(
                            movieInfo.qualityInfo, style = MaterialTheme.typography.labelSmall
                        )
                    })
                }
            }
        }
        Text(movieInfo.description)
    }
}

@Composable
internal fun FilesInfoSection(
    filesInfo: MovieDetailsForView.FileInfo,
    onDeleteButtonClick: (fileId: Int) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.height(IntrinsicSize.Min).fillMaxWidth().padding(vertical = 6.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp, vertical = 4.dp)
        ) {
            Box(
                modifier = Modifier.clip(CircleShape).background(Color(0xFF1c5c1f))
            ) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.background(Color.Transparent)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
            ) {
                Text(
                    text = filesInfo.relativePath, fontWeight = FontWeight.Bold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = filesInfo.sizeOnDisk,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        text = filesInfo.quality,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = filesInfo.dateAdded,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }
            IconButton(
                onClick = {
                    onDeleteButtonClick(filesInfo.id)
                }
            ) {
                Icon(
                    Icons.Default.Delete, contentDescription = null
                )
            }
        }
    }
}

internal fun LazyListScope.creditResourceSection(
    credits: List<CreditResource>, itemsInRow: Int, imageWidth: Dp
) {
    val creditsChunks = credits.chunked(itemsInRow)
    items(
        items = creditsChunks,
        key = { it.first().id },
    ) { creditResourceSubList ->
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            creditResourceSubList.forEach { creditResource ->
                CreditResourceItem(
                    creditResource = creditResource,
                    imageWidth = imageWidth,
                    imageHeight = round(imageWidth.value * 1.5).dp
                )
            }
        }
    }
}
