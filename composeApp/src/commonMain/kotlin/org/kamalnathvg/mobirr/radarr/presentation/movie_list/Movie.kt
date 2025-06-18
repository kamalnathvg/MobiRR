package org.kamalnathvg.mobirr.radarr.presentation.movie_list

import co.touchlab.kermit.Logger
import kotlinx.datetime.Clock.System
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import org.kamalnathvg.mobirr.radarr.data.DummyRepo
import org.kamalnathvg.mobirr.radarr.data.MovieDto
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsForView
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.toMovieDetailsForView
import kotlin.math.pow
import kotlin.math.round
import kotlin.time.DurationUnit
import kotlin.time.toDuration

internal data class Movie(
    val id: String,
    val title: String,
    val year: Int,
    val duration: String,
    val studio: String,
    val hasFile: Boolean,
    val isAvailable: Boolean,
    val isMonitored: Boolean,
    val isCutOffMet: Boolean,
    val imdbId: String,
    val tmdbId: Int,
    val overView: String,
    val added: LocalDateTime,
    val images: List<Image>,
    val genres: List<Genre>,
    val sizeOnDisk: Long,
) {
    data class Image(
        val coverType: CoverType,
        val localUrl: String,
        val remoteUrl: String
    )

    companion object {
        fun parseImageFromDto(dtoImage: MovieDto.Image): Image {
            return Image(
                coverType = dtoImage.coverType.toCoverType(),
                localUrl = dtoImage.url,
                remoteUrl = dtoImage.remoteUrl
            )
        }
    }

    fun getMovieBackDropOrDefault(): Image? {
        return this.getImage(CoverType.BACKDROP) ?: this.getImage(CoverType.FAN_ART)
        ?: this.getImage(CoverType.POSTER)
    }

    fun getMoviePosterOrDefault(): Image? {
        return this.getImage(CoverType.POSTER) ?: this.getImage(CoverType.FAN_ART) ?: this.getImage(
            CoverType.BACKDROP
        )
    }

    private fun getImage(coverType: CoverType): Image? {
        return this.images.firstOrNull { it.coverType == coverType }
    }
}

internal enum class CoverType {
    POSTER,
    FAN_ART,
    BACKDROP,
    UNKNOWN;

    companion object {
        fun fromString(value: String): CoverType {
            return when (value) {
                "poster" -> POSTER
                "fanart" -> FAN_ART
                "backdrop" -> BACKDROP
                else -> UNKNOWN
            }
        }
    }
}

internal fun String.toCoverType(): CoverType = CoverType.fromString(this)

internal enum class Genre {
    COMEDY,
    DRAMA,
    UNKNOWN;

    companion object {
        fun fromString(value: String): Genre {
            return when (value) {
                "comedy" -> COMEDY
                "drama" -> DRAMA
                else -> UNKNOWN
            }
        }
    }
}

internal fun String.toGenre(): Genre = Genre.fromString(this)

internal fun MovieDto.toMovie(): Movie {
    return Movie(
        id = this.id.toString(),
        title = this.title,
        year = this.year,
        studio = this.studio,
        hasFile = this.hasFile,
        isAvailable = this.isAvailable,
        isMonitored = this.monitored,
        isCutOffMet = this.movieFile?.qualityCutoffNotMet == true,
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
        duration = this.runtime.toRuntimeString(),
        sizeOnDisk = this.sizeOnDisk
    )
}

internal fun Long.toRuntimeString(): String {
    val duration = this.toDuration(DurationUnit.MINUTES)
    val hours = duration.inWholeHours
    val minutes = duration.minus(hours.toDuration(DurationUnit.HOURS)).inWholeMinutes
    return if (hours > 0) {
        "${hours}h ${minutes}m"
    } else {
        "${minutes}m"
    }
}

internal fun Long.toGB(): String {
    return "${round(this * 10 / (1024.0.pow(3))) / 10} GB"
}

internal fun String.parseUTCtoLocalDateTime(): LocalDateTime {
    if (this == "") {
        Logger.d("Movie") { " got an empty String for dateTime " }
        return System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }
    return Instant.parse(this, DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}


internal fun String.toDateTimeString(): String {
    val customFormat = LocalDate.Format {
        monthName(MonthNames.ENGLISH_ABBREVIATED); char(' '); dayOfMonth(); chars(", "); year()
    }
    return this.parseUTCtoLocalDateTime()
        .date
        .format(customFormat)
}

internal suspend fun getDummyMovies(): List<Movie> {
    val dummyRepo = DummyRepo.DynamicString("")
    return dummyRepo.getMovies().map { it.toMovie() }
}

internal suspend fun getDummyMovieById(movieId: Int): Result<MovieDetailsForView> {
    val dummyRepo = DummyRepo.DynamicString("")
    val movies = dummyRepo.getMovies()
    val movie = movies.firstOrNull { it.tmdbId == movieId }
    if (movie == null) {
        return Result.failure(Exception("Movie Not Found"))
    }
    val credits = dummyRepo.getDummyMetadata()
    return Result.success(movie.toMovieDetailsForView(credits))
}