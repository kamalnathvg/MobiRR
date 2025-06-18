package org.kamalnathvg.mobirr.radarr.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieDto(
    @SerialName("added")
    val added: String = "",
    @SerialName("alternateTitles")
    val alternateTitles: List<AlternateTitle> = listOf(),
    @SerialName("cleanTitle")
    val cleanTitle: String = "",
    @SerialName("collection")
    val collection: Collection = Collection(),
    @SerialName("folderName")
    val folderName: String = "",
    @SerialName("genres")
    val genres: List<String> = listOf(),
    @SerialName("hasFile")
    val hasFile: Boolean = false,
    @SerialName("id")
    val id: Int = 0,
    @SerialName("images")
    val images: List<Image> = listOf(),
    @SerialName("imdbId")
    val imdbId: String = "",
    @SerialName("inCinemas")
    val inCinemas: String = "",
    @SerialName("isAvailable")
    val isAvailable: Boolean = false,
    @SerialName("lastSearchTime")
    val lastSearchTime: String = "",
    @SerialName("minimumAvailability")
    val minimumAvailability: String = "",
    @SerialName("monitored")
    val monitored: Boolean = false,
    @SerialName("movieFile")
    val movieFile: MovieFile? = null, // TODO: Check if Movie File can be a list
    @SerialName("movieFileId")
    val movieFileId: Int = 0,
    @SerialName("originalLanguage")
    val originalLanguage: OriginalLanguage = OriginalLanguage(),
    @SerialName("originalTitle")
    val originalTitle: String = "",
    @SerialName("overview")
    val overview: String = "",
    @SerialName("path")
    val path: String = "",
    @SerialName("popularity")
    val popularity: Double = 0.0,
    @SerialName("qualityProfileId")
    val qualityProfileId: Int = 0,
    @SerialName("ratings")
    val ratings: Ratings = Ratings(),
    @SerialName("releaseDate")
    val releaseDate: String = "",
    @SerialName("rootFolderPath")
    val rootFolderPath: String = "",
    @SerialName("runtime")
    val runtime: Long = 0,
    @SerialName("secondaryYearSourceId")
    val secondaryYearSourceId: Int = 0,
    @SerialName("sizeOnDisk")
    val sizeOnDisk: Long = 0L,
    @SerialName("sortTitle")
    val sortTitle: String = "",
    @SerialName("statistics")
    val statistics: Statistics = Statistics(),
    @SerialName("status")
    val status: String = "",
    @SerialName("studio")
    val studio: String = "",
    @SerialName("tags")
    val tags: List<String> = listOf(),
    @SerialName("title")
    val title: String = "",
    @SerialName("titleSlug")
    val titleSlug: String = "",
    @SerialName("tmdbId")
    val tmdbId: Int = 0,
    @SerialName("website")
    val website: String = "",
    @SerialName("year")
    val year: Int = 0,
    @SerialName("youTubeTrailerId")
    val youTubeTrailerId: String = ""
) {

    @Serializable
    internal data class AlternateTitle(
        @SerialName("sourceType")
        val sourceType: String,
        @SerialName("movieMetadataId")
        val movieMetadataId: Int,
        @SerialName("id")
        val id: Int
    )

    @Serializable
    internal data class Collection(
        @SerialName("title")
        val title: String = "",
        @SerialName("tmdbId")
        val tmdbId: Int = 0
    )

    @Serializable
    internal data class Image(
        @SerialName("coverType")
        val coverType: String = "",
        @SerialName("remoteUrl")
        val remoteUrl: String = "",
        @SerialName("url")
        val url: String = ""
    )

    @Serializable
    internal data class MovieFile(
        @SerialName("customFormatScore")
        val customFormatScore: Int = 0,
        @SerialName("dateAdded")
        val dateAdded: String = "",
        @SerialName("edition")
        val edition: String = "",
        @SerialName("id")
        val id: Int = 0,
        @SerialName("indexerFlags")
        val indexerFlags: Int = 0,
        @SerialName("languages")
        val languages: List<Language> = listOf(),
        @SerialName("mediaInfo")
        val mediaInfo: MediaInfo = MediaInfo(),
        @SerialName("movieId")
        val movieId: Int = 0,
        @SerialName("path")
        val path: String = "",
        @SerialName("quality")
        val quality: Quality = Quality(),
        @SerialName("qualityCutoffNotMet")
        val qualityCutoffNotMet: Boolean = false,
        @SerialName("relativePath")
        val relativePath: String = "",
        @SerialName("size")
        val size: Long = 0L,
    ) {
        @Serializable
        internal data class Language(
            @SerialName("id")
            val id: Int = 0,
            @SerialName("name")
            val name: String = ""
        )

        @Serializable
        internal data class MediaInfo(
            @SerialName("audioBitrate")
            val audioBitrate: Int = 0,
            @SerialName("audioChannels")
            val audioChannels: Double = 0.0,
            @SerialName("audioCodec")
            val audioCodec: String = "",
            @SerialName("audioLanguages")
            val audioLanguages: String = "",
            @SerialName("audioStreamCount")
            val audioStreamCount: Int = 0,
            @SerialName("resolution")
            val resolution: String = "",
            @SerialName("runTime")
            val runTime: String = "",
            @SerialName("scanType")
            val scanType: String = "",
            @SerialName("subtitles")
            val subtitles: String = "",
            @SerialName("videoBitDepth")
            val videoBitDepth: Int = 0,
            @SerialName("videoBitrate")
            val videoBitrate: Int = 0,
            @SerialName("videoCodec")
            val videoCodec: String = "",
            @SerialName("videoDynamicRange")
            val videoDynamicRange: String = "",
            @SerialName("videoDynamicRangeType")
            val videoDynamicRangeType: String = "",
            @SerialName("videoFps")
            val videoFps: Float = 0f
        )

        @Serializable
        internal data class Quality(
            @SerialName("quality")
            val quality: Quality = Quality(),
            @SerialName("revision")
            val revision: Revision = Revision()
        ) {
            @Serializable
            internal data class Quality(
                @SerialName("id")
                val id: Int = 0,
                @SerialName("modifier")
                val modifier: String = "",
                @SerialName("name")
                val name: String = "",
                @SerialName("resolution")
                val resolution: Int = 0,
                @SerialName("source")
                val source: String = ""
            )

            @Serializable
            internal data class Revision(
                @SerialName("isRepack")
                val isRepack: Boolean = false,
                @SerialName("real")
                val real: Int = 0,
                @SerialName("version")
                val version: Int = 0
            )
        }
    }

    @Serializable
    internal data class OriginalLanguage(
        @SerialName("id")
        val id: Int = 0,
        @SerialName("name")
        val name: String = ""
    )

    @Serializable
    internal data class Ratings(
        @SerialName("imdb")
        val imdb: Imdb = Imdb(),
        @SerialName("tmdb")
        val tmdb: Tmdb = Tmdb()
    ) {
        @Serializable
        internal data class Imdb(
            @SerialName("type")
            val type: String = "",
            @SerialName("value")
            val value: Double = 0.0,
            @SerialName("votes")
            val votes: Int = 0
        )

        @Serializable
        internal data class Tmdb(
            @SerialName("type")
            val type: String = "",
            @SerialName("value")
            val value: Double = 0.0,
            @SerialName("votes")
            val votes: Int = 0
        )
    }

    @Serializable
    internal data class Statistics(
        @SerialName("movieFileCount")
        val movieFileCount: Int = 0,
        @SerialName("releaseGroups")
        val releaseGroups: List<String> = listOf(),
        @SerialName("sizeOnDisk")
        val sizeOnDisk: Long = 0L
    )
}


