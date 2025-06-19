package org.kamalnathvg.mobirr.previews.movie_add

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.MobiRRTheme
import org.kamalnathvg.mobirr.previews.movie_details.getMovies
import org.kamalnathvg.mobirr.radarr.presentation.movie_add.MovieSearchResultItem


@Preview
@Composable
private fun MovieLookupListItemPreview() {
    val movie = getMovies().first()
    MobiRRTheme {
        MovieSearchResultItem(
            movie = movie,
            isExpanded = true,
            onClick = {},
            onAddMovie = {}
        )
    }
}