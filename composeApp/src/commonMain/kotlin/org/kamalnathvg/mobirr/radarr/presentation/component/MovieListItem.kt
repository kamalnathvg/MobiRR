package org.kamalnathvg.mobirr.radarr.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mobirr.composeapp.generated.resources.Res
import mobirr.composeapp.generated.resources.icon_movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toSizeInGB
import org.kamalnathvg.mobirr.utils.LoadImageFromUrl

@Composable
internal fun MovieListItem(
    movie: Movie,
    onMovieClick: () -> Unit,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clickable {
                onMovieClick()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LoadImageFromUrl(
                url = movie.getMoviePosterOrDefault()?.remoteUrl.toString(),
                onLoading = {
                    CircularProgressIndicator()
                },
                onClick = onMovieClick,
                onError = Res.drawable.icon_movie,
                modifier = Modifier
                    .height(120.dp)
                    .width(80.dp)
            )
            Box{
                LoadImageFromUrl(
                    url = movie.getMovieBackDropOrDefault()?.remoteUrl.toString(),
                    onClick = onMovieClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .alpha(0.1f)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .padding(
                            horizontal = 12.dp,
                            vertical = 8.dp
                        )
                        .fillMaxHeight()
                ) {
                    Text(
                        text = movie.title,
                        maxLines = 2,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        movie.studio,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        movie.year.toString(),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Medium
                    )
                    if (movie.sizeOnDisk != 0L){
                        Row {
                            Text(
                                text = movie.sizeOnDisk.toSizeInGB(),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    }
}