package org.kamalnathvg.mobirr

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenWidth(): Dp = with(LocalDensity.current) {
    return LocalWindowInfo.current.containerSize.width.dp
}

@Composable
actual fun getScreenHeight(): Dp {
   return LocalWindowInfo.current.containerSize.height.dp
}