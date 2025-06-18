package org.kamalnathvg.mobirr.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.touchlab.kermit.Logger
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private const val TAG = "LoadImageFromUrl"

@Composable
internal fun LoadImageFromUrl(
    url: String,
    onClick: () -> Unit = {},
    onLoading: @Composable () -> Unit = {},
    onError: DrawableResource? = null,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable(
                onClick = onClick
            ),
    ) {
        val painter = rememberAsyncImagePainter(url)
        val state = painter.state.collectAsStateWithLifecycle()

        when (val result = state.value) {
            is AsyncImagePainter.State.Empty,
            is AsyncImagePainter.State.Loading -> onLoading

            is AsyncImagePainter.State.Error -> {
                result.result.throwable.printStackTrace()
                Logger.e(TAG) { "Error Fetching Image from Url: $url" }
                Logger.e(TAG) { result.toString() }
                onError?.let {
                    Image(
                        painter = painterResource(onError),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(IntrinsicSize.Max)
                            .width(IntrinsicSize.Max)
                    )
                }
            }

            is AsyncImagePainter.State.Success -> {
                val isValidImage =
                    result.painter.intrinsicSize.width > 1 && result.painter.intrinsicSize.height > 1
                if (isValidImage) {
                    Image(
                        painter = result.painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(IntrinsicSize.Max)
                            .width(IntrinsicSize.Max)
                    )
                } else {
                    Logger.e(TAG) { "Invalid image dimensions" }
                    onError
                }
            }
        }
    }
}
