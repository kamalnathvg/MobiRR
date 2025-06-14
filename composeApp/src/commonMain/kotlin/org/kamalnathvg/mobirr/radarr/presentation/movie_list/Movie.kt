package org.kamalnathvg.mobirr.radarr.presentation.movie_list

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.DateTimeComponents
import org.kamalnathvg.mobirr.radarr.data.DummyRepo
import org.kamalnathvg.mobirr.radarr.data.MovieDto
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal data class Movie(
    val id: String,
    val title: String,
    val year: Int,
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
        }
    )
}

internal fun String.parseUTCtoLocalDateTime(): LocalDateTime{

    return Instant.parse(this, DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}




internal suspend fun getDummyMovies(count: Int = 10): List<Movie>{
    val dummyRepo = DummyRepo.DynamicString("")
    return dummyRepo.asMovies().map { it.toMovie() }
}