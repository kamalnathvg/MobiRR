package org.kamalnathvg.mobirr.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import co.touchlab.kermit.Logger
import org.koin.compose.KoinContext
import androidx.navigation.compose.NavHost
import com.example.compose.MobiRRTheme
import org.kamalnathvg.mobirr.radarr.navigation.RadarrGraph
import org.kamalnathvg.mobirr.radarr.navigation.radarrGraph

@Composable
fun App() {
    MobiRRTheme {
        KoinContext {
            val navController = rememberNavController()
            navController.addOnDestinationChangedListener { _,destination, _ ->
                Logger.d("NAV_CONTROLLER") {"Navigating to ${destination.route}"}
            }
            NavHost(
                navController = navController,
                startDestination = RadarrGraph
            ) {
                radarrGraph(navController)
            }
        }
    }
}