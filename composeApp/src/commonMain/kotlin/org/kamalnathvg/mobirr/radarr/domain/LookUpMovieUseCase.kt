package org.kamalnathvg.mobirr.radarr.domain

import org.kamalnathvg.mobirr.radarr.data.MovieDto
import org.kamalnathvg.mobirr.radarr.data.RadarrRepository
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toMovie

internal class LookUpMovieUseCase(
    private val radarrRepository: RadarrRepository
) {
    suspend operator fun invoke(searchTerm: String): Result<List<Movie>> {
        return radarrRepository.lookupMovie(searchTerm).map { movieDtos ->
            movieDtos.map {
                it.toMovie()
            }
        }
    }
}