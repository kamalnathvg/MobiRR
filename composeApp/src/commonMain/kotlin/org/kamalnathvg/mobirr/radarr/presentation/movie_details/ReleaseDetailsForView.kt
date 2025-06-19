package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import org.kamalnathvg.mobirr.radarr.data.ReleaseDto
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.ReleaseDetailsForView.Companion.toDurationForView
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toSizeInGB
import kotlin.math.round
import kotlin.time.DurationUnit
import kotlin.time.toDuration

internal data class ReleaseDetailsForView(
    val guid: String,
    val title: String,
    val quality: String,
    val added: String,
    val size: String,
) {
    companion object {
        fun Double.toDurationForView(): String {
            val duration = this.toDuration(DurationUnit.MINUTES)
            val days = duration.inWholeDays
            val hours = duration.inWholeHours % 24
            val minutes = round(this).toInt() % 60
            if (days > 0) {
                return "${days}d ${hours}h ${minutes}m"
            }
            if (hours > 0) {
                return "${hours}h ${minutes}m"
            }
            return "${minutes}m"
        }
    }
}


internal fun ReleaseDto.toReleaseDetailsForView(): ReleaseDetailsForView {
    return ReleaseDetailsForView(
        guid = this.guid ?: "",
        title = this.title ?: "",
        quality = this.quality.quality.name ?: "",
        added = this.ageMinutes.toDurationForView(),
        size = this.size.toSizeInGB(),
    )
}


