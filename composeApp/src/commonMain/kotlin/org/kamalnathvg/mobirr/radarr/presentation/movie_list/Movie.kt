package org.kamalnathvg.mobirr.radarr.presentation.movie_list

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.DateTimeComponents
import org.kamalnathvg.mobirr.radarr.data.DummyRepo
import org.kamalnathvg.mobirr.radarr.data.MovieDto
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsForView
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.toMovieDetailsForView
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

internal data class Movie(
    val id: String,
    val title: String,
    val year: Int,
    val duration: String,
    val studio: String,
    val hasFile: Boolean,
    val isAvailable: Boolean,
    val imdbId: String,
    val tmdbId: Int,
    val overView: String,
    val added: LocalDateTime,
    val images: List<Image>,
    val genres: List<Genre>
){
    data class Image(
        val coverType: CoverType,
        val localUrl: String,
        val remoteUrl: String
    )

    companion object{
        fun parseImageFromDto(dtoImage: MovieDto.Image) : Image{
            return Image(
                coverType = dtoImage.coverType.toCoverType(),
                localUrl = dtoImage.url,
                remoteUrl = dtoImage.remoteUrl
            )
        }
    }
    fun getMovieBackDropOrDefault(): Image?{
        return this.getImage(CoverType.BACKDROP) ?:
         this.getImage(CoverType.FAN_ART) ?:
         this.getImage(CoverType.POSTER)
    }

    fun getMoviePosterOrDefault(): Image?{
        return this.getImage(CoverType.POSTER) ?:
        this.getImage(CoverType.FAN_ART) ?:
        this.getImage(CoverType.BACKDROP)
    }

    private fun getImage(coverType: CoverType): Image?{
        return this.images.firstOrNull{it.coverType == coverType}
    }
}



internal enum class CoverType{
    POSTER,
    FAN_ART,
    BACKDROP,
    UNKNOWN;

    companion object {
        fun fromString(value: String): CoverType{
            return when(value){
                "poster" -> POSTER
                "fanart" -> FAN_ART
                "backdrop" -> BACKDROP
                else -> UNKNOWN
            }
        }
    }
}
internal fun String.toCoverType(): CoverType = CoverType.fromString(this)

internal enum class Genre{
    COMEDY,
    DRAMA,
    UNKNOWN;

    companion object{
        fun fromString(value: String): Genre{
            return when(value){
                "comedy" -> COMEDY
                "drama" -> DRAMA
                else -> UNKNOWN
            }
        }
    }
}

internal fun String.toGenre(): Genre = Genre.fromString(this)

internal fun MovieDto.toMovie(): Movie{
    return Movie(
        id = this.id.toString(),
        title = this.title,
        year = this.year,
        studio = this.studio,
        hasFile = this.hasFile,
        isAvailable = this.isAvailable,
        imdbId = this.imdbId,
        tmdbId = this.tmdbId,
        overView = this.overview,
        added = this.added.parseUTCtoLocalDateTime(),
        images = images.map { dtoImage ->
            Movie.parseImageFromDto(dtoImage)
        },
        genres = genres.map { dtoGenre ->
            dtoGenre.toGenre()
        },
        duration = this.runtime.toRuntimeString()
    )
}


internal fun Long.toRuntimeString(): String{
    val duration = this.seconds
    return "${duration.inWholeHours}h ${duration.inWholeMinutes}"
}



internal fun String.parseUTCtoLocalDateTime(): LocalDateTime{

    return Instant.parse(this, DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}




internal suspend fun getDummyMovies(count: Int = 10): List<Movie>{
    val dummyRepo = DummyRepo.DynamicString("")
    return dummyRepo.asMovies().map { it.toMovie() }
}

internal suspend fun getDummyMovieById(movieId: Int): Result<MovieDetailsForView>{
    val dummyRepo = DummyRepo.DynamicString("")
    val movies = dummyRepo.asMovies()
    val movie = movies.firstOrNull { it.tmdbId == movieId }
    if(movie == null){
        return Result.failure(Exception("Movie Not Found"))
    }
    return Result.success(movie.toMovieDetailsForView())
}