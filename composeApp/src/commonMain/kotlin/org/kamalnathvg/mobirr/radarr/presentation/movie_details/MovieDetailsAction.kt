package org.kamalnathvg.mobirr.radarr.presentation.movie_details

internal sealed class MovieDetailsAction{
    data class GetMovieDetails(val movieId: Int): MovieDetailsAction()
    data class GetReleases(val movieId: Int): MovieDetailsAction()
    data class DeleteMovieFile(val fileId: Int): MovieDetailsAction()
    data class AddRelease(val guid: String): MovieDetailsAction()
}