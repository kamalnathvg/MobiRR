package org.kamalnathvg.mobirr.previews.movie_details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.MobiRRTheme
import kotlinx.serialization.json.Json
import org.kamalnathvg.mobirr.previews.creditResources
import org.kamalnathvg.mobirr.previews.moviesJson
import org.kamalnathvg.mobirr.radarr.data.MovieDto
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.CreditResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsForView
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsScreen
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsScreenState
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.toMovieDetailsForView
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toMovie


internal fun getMoviesDto(): List<MovieDto>{
    val json = Json{ignoreUnknownKeys = true}
    val moviesDto = json.decodeFromString<List<MovieDto>>(moviesJson)
    return moviesDto
}

internal fun getCreditResources(): List<CreditResource>{
    val json = Json{ignoreUnknownKeys = true}
    val credits = json.decodeFromString<List<CreditResource>>(creditResources)
    return credits
}

internal fun getMovieDetailsForView(movieId: Int): MovieDetailsForView{
    val moviesDto = getMoviesDto()
    val movieDto = moviesDto.first{it.id == movieId}
    val credits =  getCreditResources()
    return movieDto.toMovieDetailsForView(credits)
}

internal fun getMovies(): List<Movie>{
    return getMoviesDto().map { it.toMovie() }
}

@Preview(
    showSystemUi = true,
    device = "id:pixel_8",
    showBackground = true
)
@Composable
internal fun MovieDetailsScreenPreview(){
    val movieDetails = getMovieDetailsForView(movieId = 3)
    val state = MovieDetailsScreenState(
        movieDetailsForView = movieDetails,
        errorMessage = null,
        searchResult = emptyList(),
    )
    MobiRRTheme {
        MovieDetailsScreen(
            state = state,
            onAction = {},
            onNavigateBack = {},
        )
    }
}