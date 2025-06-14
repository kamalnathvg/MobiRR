package org.kamalnathvg.mobirr

import androidx.compose.ui.window.ComposeUIViewController
import org.kamalnathvg.mobirr.app.App
import org.kamalnathvg.mobirr.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }