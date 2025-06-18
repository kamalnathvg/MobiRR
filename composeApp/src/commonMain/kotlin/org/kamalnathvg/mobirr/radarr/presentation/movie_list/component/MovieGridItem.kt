package org.kamalnathvg.mobirr.radarr.presentation.movie_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.touchlab.kermit.Logger
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import mobirr.composeapp.generated.resources.Res
import mobirr.composeapp.generated.resources.demo_poster
import mobirr.composeapp.generated.resources.icon_movie
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListAction
import org.kamalnathvg.mobirr.utils.LoadImageFromUrl

private const val TAG = "MovieGridItem"

@Composable
internal fun MovieGridItem(
    movie: Movie,
    onMovieClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LoadImageFromUrl(
        url = movie.getMoviePosterOrDefault()?.remoteUrl.toString(),
        onLoading = {
            CircularProgressIndicator()
        },
        onError = Res.drawable.icon_movie,
        modifier = Modifier
            .height(150.dp)
            .width(80.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}
