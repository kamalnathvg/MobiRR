package org.kamalnathvg.mobirr.radarr.presentation.movie_list.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import co.touchlab.kermit.Logger
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import mobirr.composeapp.generated.resources.Res
import mobirr.composeapp.generated.resources.demo_poster
import mobirr.composeapp.generated.resources.icon_movie
import org.jetbrains.compose.resources.painterResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie

private const val TAG = "MovieGridItem"
@Composable
internal fun MovieGridItem(
    onMovieClick: (Movie) -> Unit, movie: Movie
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .height(IntrinsicSize.Max).clickable(
            onClick = {
                onMovieClick(movie)
            }),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(200.dp)
                .width(132.dp)
                .clip(RoundedCornerShape(12.dp))

        ){
            var imageLoadResult by remember {
                mutableStateOf<Result<Painter>?>(null)
            }
            val painter = rememberAsyncImagePainter(
                model = movie.images[0].remoteUrl,
                onSuccess = {

                    val isValidImage = it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1
                    imageLoadResult = if (isValidImage){
                        Result.success(it.painter)
                    }else{
                        Logger.e(TAG){"Invalid image Size"}
                        Result.failure(Exception("Invalid Image Size"))
                    }
                },
                onError = {
                    it.result.throwable.printStackTrace()
                    imageLoadResult = Result.failure(Exception(it.result.throwable))
                    Logger.e(TAG){"Error Fetching Image for Movie ${movie.title} url: ${movie.images[0].remoteUrl}"}
                    Logger.e(TAG) { it.result.toString() }
                }
            )
            when( val result = imageLoadResult){
                null -> {
                    CircularProgressIndicator()
                }
                else -> {
                    Image(
                        painter = if (result.isSuccess){
                            painter
                        }else{
//                            painterResource(Res.drawable.icon_movie)
                            painterResource(Res.drawable.demo_poster)
                        },
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(IntrinsicSize.Max)
                            .width(IntrinsicSize.Max)
                    )
                }
            }
        }
    }
}