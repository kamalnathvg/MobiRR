package org.kamalnathvg.mobirr.radarr.presentation.movie_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.touchlab.kermit.Logger
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import org.kamalnathvg.mobirr.getScreenWidth
import org.kamalnathvg.mobirr.radarr.data.CreditResource
import kotlin.math.round

private const val TAG = "CreditResourceItem"


@Composable
internal fun CreditResourceItem(
    creditResource: CreditResource, imageWidth: Dp, imageHeight: Dp
) {
    val painter = rememberAsyncImagePainter(model = creditResource.images.firstOrNull()?.remoteUrl)
    val painterState by painter.state.collectAsStateWithLifecycle()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(imageWidth).padding(2.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(imageHeight).width(imageWidth).clip(RoundedCornerShape(8.dp))
        ) {
            when (painterState) {
                is AsyncImagePainter.State.Success -> {
                    Image(
                        painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

                else -> {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                    )
                }
            }
        }
        Text(
            text = creditResource.personName,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            minLines = 2,
            textAlign = TextAlign.Center
        )
        Text(
            text = if (creditResource.character.isEmpty()) creditResource.job else creditResource.character,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

@Composable
internal fun getCreditItemRowCountAndWidth(): Pair<Int, Dp> {
    val screenWidth = getScreenWidth() * 2
    Logger.d(TAG) { screenWidth.toString() }
    val itemsInRow = ((screenWidth + 32.dp) / 84.dp).toInt().coerceAtLeast(1)
    val itemWidth = round((screenWidth / itemsInRow).value)
    return Pair(itemsInRow, itemWidth.dp)
}
