package org.kamalnathvg.mobirr.radarr.presentation.movie_list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.kamalnathvg.mobirr.radarr.presentation.component.MovieListItem
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListAction


@Composable
internal fun MovieListView(
    lazyListState: LazyListState,
    movies: List<Movie>,
    onAction: (MovieListAction) -> Unit
) {

    LazyColumn(
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = movies, key = { it.id }) { movie ->
            MovieListItem(
                movie = movie, onMovieClick = {
                    onAction(MovieListAction.OnMovieClick(movie))
                }, modifier = Modifier
            )
        }
    }
}
