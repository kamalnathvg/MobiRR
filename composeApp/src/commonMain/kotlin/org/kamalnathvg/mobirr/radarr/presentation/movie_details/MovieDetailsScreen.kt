package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.touchlab.kermit.Logger
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import mobirr.composeapp.generated.resources.Res
import mobirr.composeapp.generated.resources.demo_poster
import mobirr.composeapp.generated.resources.imdb
import mobirr.composeapp.generated.resources.tmdb
import org.jetbrains.compose.resources.painterResource
import org.kamalnathvg.mobirr.getScreenWidth
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
        skipPartiallyExpanded = true
    )
    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                for (i in 1..100) {
                    Text("Item $i")
                }
            }
        }
    }
    Surface{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
                .statusBarsPadding(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            when (val movieDetails = state.movieDetailsForView) {
                null -> CircularProgressIndicator()
                else -> {
                    MovieInfoSection(
                        movieInfo = movieDetails.movieInfo,
                        onNavigateBack = onNavigateBack,
                        onSearchClick = {
                            showBottomSheet = true
                            onAction(MovieDetailsAction.GetSearchResults(movieDetails.id))
                        }
                    )
                    movieDetails.filesInfo?.let { fileInfo ->
                        FilesInfoSection(
                            filesInfo = fileInfo,
                            onDeleteButtonClick = { fileId ->
                                onAction(MovieDetailsAction.DeleteMovieFile(fileId))
                            }
                        )
                    }
                    CreditInfoSection(
                        credits = movieDetails.credits,
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
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(bottom = 4.dp), verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min).padding(
                    vertical = 12.dp
                )
        ) {
            AsyncImage(
                model = movieInfo.getMoviePosterOrDefault()?.remoteUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = painterResource(Res.drawable.demo_poster),
                modifier = Modifier
                    .width(150.dp)
                    .height(250.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Text(
                        text = movieInfo.title, style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .weight(1f)
                    )
                    IconButton(
                        onClick = onSearchClick,
                    ) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
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
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .padding(vertical = 6.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF1c5c1f))
            ) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(Color.Transparent)
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

                }) {
                Icon(
                    Icons.Default.Delete, contentDescription = null
                )
            }
        }
    }
}


@Composable
internal fun CreditInfoSection(
    credits: List<CreditResource>,
) {
    val screenWidth = getScreenWidth() * 2
    Logger.d(TAG) { screenWidth.toString()  }
    val itemsInRow = ((screenWidth + 32.dp) / 84.dp).toInt().coerceAtLeast(1)
    val itemWidth = round((screenWidth / itemsInRow).value)
    val itemHeight = round(itemWidth * 1.5)

    val creditsChunks = credits.chunked(itemsInRow)
    creditsChunks.forEachIndexed { index, creditResourceList ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            creditResourceList.forEach { creditResource ->
                CreditResourceItem(
                    creditResource = creditResource,
                    imageWidth = itemWidth.dp,
                    imageHeight = itemHeight.dp
                )
            }
        }
    }
}

@Composable
internal fun CreditResourceItem(
    creditResource: CreditResource,
    imageWidth: Dp,
    imageHeight: Dp
) {
    val painter = rememberAsyncImagePainter(model = creditResource.images.firstOrNull()?.remoteUrl)
    val painterState by painter.state.collectAsStateWithLifecycle()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(imageWidth)
            .padding(2.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(imageHeight)
                .width(imageWidth)
                .clip(RoundedCornerShape(8.dp))
        ) {
            when (painterState) {
                is AsyncImagePainter.State.Success -> {
                    Image(
                        painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

                else -> {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                    )
                }
            }
        }
        Text(
            text = creditResource.personName,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            minLines = 2,
            textAlign = TextAlign.Center
        )
        Text(
            text = if (creditResource.character.isEmpty()) creditResource.job else creditResource.character,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}