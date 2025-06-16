package org.kamalnathvg.mobirr

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import co.touchlab.kermit.Logger

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
actual fun getScreenWidth(): Dp {
    Logger.d("LocalConfiguration") { "Screen Width Calculated" }
    val configuration = LocalConfiguration.current
    return with(LocalDensity.current) { configuration.screenWidthDp.toDp() }
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
actual fun getScreenHeight(): Dp {
    val configuration = LocalConfiguration.current
    return with(LocalDensity.current){configuration.screenHeightDp.toDp()}
}