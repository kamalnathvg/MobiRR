package org.kamalnathvg.mobirr.radarr.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReleaseDto(
    @SerialName("age") val age: Int = 0,
    @SerialName("ageHours") val ageHours: Double = 0.0,
    @SerialName("ageMinutes") val ageMinutes: Double = 0.0,
    @SerialName("approved") val approved: Boolean = false,
    @SerialName("commentUrl") val commentUrl: String? = null,
    @SerialName("customFormatScore") val customFormatScore: Int = 0,
    @SerialName("downloadAllowed") val downloadAllowed: Boolean = false,
    @SerialName("downloadUrl") val downloadUrl: String? = null,
    @SerialName("edition") val edition: String? = null,
    @SerialName("guid") val guid: String? = null,
    @SerialName("imdbId") val imdbId: Int = 0,
    @SerialName("indexer") val indexer: String? = null,
    @SerialName("indexerFlags") val indexerFlags: List<String> = listOf(),
    @SerialName("indexerId") val indexerId: Int = 0,
    @SerialName("infoHash") val infoHash: String? = null,
    @SerialName("infoUrl") val infoUrl: String? = null,
    @SerialName("languages") val languages: List<Language> = listOf(),
    @SerialName("leechers") val leechers: Int? = null,
    @SerialName("magnetUrl") val magnetUrl: String? = null,
    @SerialName("mappedMovieId") val mappedMovieId: Int? = null,
    @SerialName("movieTitles") val movieTitles: List<String> = listOf(),
    @SerialName("protocol") val protocol: DownloadProtocol = DownloadProtocol.UNKNOWN,
    @SerialName("publishDate") val publishDate: String = "",
    @SerialName("quality") val quality: Quality,
    @SerialName("qualityWeight") val qualityWeight: Int = 0,
    @SerialName("rejected") val rejected: Boolean = false,
    @SerialName("rejections") val rejections: List<String>? = null,
    @SerialName("releaseGroup") val releaseGroup: String? = null,
    @SerialName("releaseHash") val releaseHash: String? = null,
    @SerialName("releaseWeight") val releaseWeight: Int = 0,
    @SerialName("sceneSource") val sceneSource: Boolean = false,
    @SerialName("seeders") val seeders: Int? = null,
    @SerialName("size") val size: Long = 0,
    @SerialName("temporarilyRejected") val temporarilyRejected: Boolean = false,
    @SerialName("title") val title: String? = null,
    @SerialName("tmdbId") val tmdbId: Int = 0
) {
    @Serializable
    internal data class Language(
        @SerialName("id") val id: Int = 0, @SerialName("name") val name: String = ""
    )

    @Serializable
    internal data class Quality(
        @SerialName("quality") val quality: Quality, @SerialName("revision") val revision: Revision
    ) {
        @Serializable
        internal data class Quality(
            @SerialName("id") val id: Int = 0,
            @SerialName("modifier") val modifier: Modifier,
            @SerialName("name") val name: String? = null,
            @SerialName("resolution") val resolution: Int = 0,
            @SerialName("source") val source: QualitySource
        )

        @Serializable
        internal data class Revision(
            @SerialName("isRepack") val isRepack: Boolean = false,
            @SerialName("real") val real: Int = 0,
            @SerialName("version") val version: Int = 0
        )
    }

    @Serializable
    enum class DownloadProtocol {
        @SerialName("unknown")
        UNKNOWN,

        @SerialName("usenet")
        USENET,

        @SerialName("torrent")
        TORRENT
    }

    @Serializable
    enum class QualitySource {
        @SerialName("unknown")
        UNKNOWN,

        @SerialName("cam")
        CAM,

        @SerialName("telesync")
        TELESYNC,

        @SerialName("telecine")
        TELECINE,

        @SerialName("workprint")
        WORKPRINT,

        @SerialName("dvd")
        DVD,

        @SerialName("tv")
        TV,

        @SerialName("webdl")
        WEBDL,

        @SerialName("webrip")
        WEBRIP,

        @SerialName("bluray")
        BLURAY
    }

    enum class Modifier {
        @SerialName("none")
        NONE,

        @SerialName("regional")
        REGIONAL,

        @SerialName("screener")
        SCREENER,

        @SerialName("rawhd")
        RAWHD,

        @SerialName("brdisk")
        BRDISK,

        @SerialName("remux")
        REMUX;

    }
}