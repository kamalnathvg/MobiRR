package org.kamalnathvg.mobirr.radarr.presentation.movie_list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import mobirr.composeapp.generated.resources.Res
import mobirr.composeapp.generated.resources.icon_movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListAction
import org.kamalnathvg.mobirr.utils.LoadImageFromUrl


@Composable
internal fun MovieGridView(
    lazyGridState: LazyGridState, movies: List<Movie>, onAction: (MovieListAction) -> Unit
) {
    LazyVerticalGrid(
        state = lazyGridState,
        columns = GridCells.Adaptive(minSize = 80.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(
            items = movies, key = { it.id }) { movie ->
            LoadImageFromUrl(
                url = movie.getMoviePosterOrDefault()?.remoteUrl.toString(),
                onClick = {
                    onAction(MovieListAction.OnMovieClick(movie))
                },
                onLoading = {
                    CircularProgressIndicator()
                },
                onError = Res.drawable.icon_movie,
                modifier = Modifier.height(148.dp)
                    .width(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

