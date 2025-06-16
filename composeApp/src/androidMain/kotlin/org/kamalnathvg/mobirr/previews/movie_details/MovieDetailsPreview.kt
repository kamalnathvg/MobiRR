package org.kamalnathvg.mobirr.previews.movie_details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.json.Json
import org.kamalnathvg.mobirr.previews.creditResources
import org.kamalnathvg.mobirr.previews.moviesJson
import org.kamalnathvg.mobirr.radarr.data.MovieDto
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.CreditResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsForView
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsScreen
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsScreenState
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.toMovieDetailsForView


internal fun getMovieDetailsForView(movieId: Int): MovieDetailsForView{
    val json = Json{ignoreUnknownKeys = true}
    val moviesDto = json.decodeFromString<List<MovieDto>>(moviesJson)
    val movieDto = moviesDto.first{it.id == movieId}
    val credits = json.decodeFromString<List<CreditResource>>(creditResources)
    return movieDto.toMovieDetailsForView(credits)
}

@Preview(showSystemUi = true, device = "id:pixel_8")
@Composable
internal fun MovieDetailsScreenPreview(){
    val movieDetails = getMovieDetailsForView(movieId = 3)
    val state = MovieDetailsScreenState(
        movieDetailsForView = movieDetails,
        errorMessage = null,
        searchResult = emptyList(),
    )
    MovieDetailsScreen(
        state = state,
        onAction = {},
        onNavigateBack = {},
    )
}