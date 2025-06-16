package org.kamalnathvg.mobirr.radarr.presentation.movie_details


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CreditResource(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("personName")
    val personName: String = "",
    @SerialName("personTmdbId")
    val personTmdbId: Int = 0,
    @SerialName("creditTmdbId")
    val creditTmdbId: String = "",
    @SerialName("character")
    val character: String = "",
    @SerialName("department")
    val department: String = "",
    @SerialName("images")
    val images: List<Image> = listOf(),
    @SerialName("job")
    val job: String = "",
    @SerialName("movieMetadataId")
    val movieMetadataId: Int = 0,
    @SerialName("order")
    val order: Int = 0,
    @SerialName("type")
    val type: String = ""
) {
    @Serializable
    internal data class Image(
        @SerialName("coverType")
        val coverType: String = "",
        @SerialName("remoteUrl")
        val remoteUrl: String = "",
        @SerialName("url")
        val url: String = ""
    )
}