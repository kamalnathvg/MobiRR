package org.kamalnathvg.mobirr.app

import org.kamalnathvg.mobirr.radarr.navigation.RadarrGraph
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import co.touchlab.kermit.Logger
import com.example.compose.MobiRRTheme
import org.kamalnathvg.mobirr.app.navigation.AppBottomNavBar
import org.kamalnathvg.mobirr.radarr.navigation.movieAddGraph
import org.kamalnathvg.mobirr.radarr.navigation.radarrGraph
import org.koin.compose.KoinContext

@Composable
fun App() {
    MobiRRTheme {
        KoinContext {
            val navController = rememberNavController()
            navController.addOnDestinationChangedListener { _, destination, _ ->
                Logger.d("NAV_CONTROLLER") { "Navigating to ${destination.route}" }
            }
            NavHost(
                navController = navController,
                startDestination = RadarrGraph
            ) {
                radarrGraph(navController) { AppBottomNavBar(navController) }
                movieAddGraph(navController) { AppBottomNavBar(navController) }
            }
        }
    }
}