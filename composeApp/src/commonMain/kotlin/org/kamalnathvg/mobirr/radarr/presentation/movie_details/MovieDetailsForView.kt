package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import org.kamalnathvg.mobirr.radarr.data.MovieDto
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsForView.FileInfo
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.CoverType
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie.Image
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toCoverType
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toRuntimeString
import kotlin.math.round

internal data class MovieDetailsForView(
    val id: Int,
    val imdbId: String,
    val tmdbId: Int,
    val movieInfo: MovieInfo,
    val filesInfo: List<FileInfo>

){
    data class MovieInfo(
        val images: List<Image>,
        val title: String,
        val year: String,
        val runtime: String,
        val tmdbRating: String,
        val imdbRating: String,
        val downloadStatus: String,
        val qualityInfo: String,
        val description: String,
    ){

        fun getMovieBackDropOrDefault(): MovieDetailsForView.Image?{
            return this.getImage(CoverType.BACKDROP) ?:
            this.getImage(CoverType.FAN_ART) ?:
            this.getImage(CoverType.POSTER)
        }

        fun getMoviePosterOrDefault(): MovieDetailsForView.Image?{
            return this.getImage(CoverType.POSTER) ?:
            this.getImage(CoverType.FAN_ART) ?:
            this.getImage(CoverType.BACKDROP)
        }

        private fun getImage(coverType: CoverType): MovieDetailsForView.Image?{
            return this.images.firstOrNull{it.coverType == coverType}
        }
    }
    data class FileInfo(
        val path: String,
        val sizeOnDisk: String,
        val dateAdded: String,
        val languages: List<String>,
        val quality: String,
        val resolution: String
    ){
        data class AudioInfo(
            val audioBitrate: String,
            val audioChannel: String,
            val audioCodec: String,
            val audioLanguages: String,
            val audioStreamCount: String,
        )
        data class VideoInfo(
            val videoBitDepth: String,
            val videoBitrate: String,
            val videoCodec: String,
            val videoFps: String,
            val videoDynamicRange: String,
            val videoDynamicRangeType: String
        )
    }
    data class Image(
        val coverType: CoverType,
        val localUrl: String,
        val remoteUrl: String
    )
    companion object{
        fun parseImageFromDto(dtoImage: MovieDto.Image) : MovieDetailsForView.Image {
            return Image(
                coverType = dtoImage.coverType.toCoverType(),
                localUrl = dtoImage.url,
                remoteUrl = dtoImage.remoteUrl
            )
        }
    }
}



internal fun MovieDto.toMovieDetailsForView(): MovieDetailsForView{
    return MovieDetailsForView(
        id = this.id,
        imdbId = this.imdbId,
        tmdbId = this.tmdbId,
        movieInfo = MovieDetailsForView.MovieInfo(
            images = this.images.map {
                MovieDetailsForView.parseImageFromDto(it)
            },
            title = this.title,
            year = this.year.toString(),
            runtime = this.runtime.toRuntimeString(),
            tmdbRating = (round(this.ratings.tmdb.value * 10) / 10).toString(),
            imdbRating = (round(this.ratings.imdb.value * 10) / 10).toString(),
            downloadStatus = if (this.hasFile) "Downloaded" else "Not Downloaded",
            qualityInfo = this.movieFile.quality.quality.name, //TODO: there's a chance this will break due to movie file being multiple files
            description =  this.overview,
        ),
        filesInfo = listOf(FileInfo(
            path = this.movieFile.path,
            sizeOnDisk = this.movieFile.size.toString(),
            dateAdded = this.movieFile.dateAdded,
            languages = listOf(this.movieFile.languages.first().name),
            quality = this.movieFile.quality.quality.name,
            resolution = this.movieFile.quality.quality.resolution.toString()
        )
    ))
}