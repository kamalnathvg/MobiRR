package org.kamalnathvg.mobirr.radarr.data

import org.kamalnathvg.mobirr.radarr.presentation.movie_details.CreditResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.getDummyMovies

internal class RadarrRepositoryImpl: RadarrRepository {
    override suspend fun getAllMovies(): Result<List<MovieDto>> {
        return Result.success(DummyRepo().getMovies())
    }

    override suspend fun getMovieById(movieId: Int): Result<MovieDto> {
        val movies = DummyRepo().getMovies()
        val movie = movies.first{it.id == movieId}
        return Result.success(movie)
    }

    override suspend fun getCreditResources(movieId: Int): Result<List<CreditResource>> {
        val creditResources = DummyRepo().getDummyMetadata()
        return Result.success(creditResources)
    }

}