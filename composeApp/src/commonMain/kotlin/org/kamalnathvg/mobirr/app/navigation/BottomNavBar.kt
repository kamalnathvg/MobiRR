package org.kamalnathvg.mobirr.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.kamalnathvg.mobirr.radarr.navigation.RadarrGraph

internal data class NavigationItem<T : Any>(
    val name: String,
    val icon: ImageVector,
    val route: T,
)


internal val navigationItems = listOf(
    NavigationItem(
        name = "Radarr",
        icon = Icons.Default.Movie,
        route = RadarrGraph.MovieList
    ),
    NavigationItem(
        name = "Settings",
        icon = Icons.Default.Settings,
        route = RadarrGraph.MovieList
    )
)

@Composable
fun AppBottomNavBar(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        navigationItems.forEach { navItem ->
            val selected =
                currentDestination?.hierarchy?.any { it.hasRoute(navItem.route::class) } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        navItem.icon,
                        tint = if (selected) MaterialTheme.colorScheme.primary else LocalContentColor.current,
                        contentDescription = navItem.name
                    )
                },
                label = {
                    Text(
                        text = navItem.name,
                        color = if (selected) MaterialTheme.colorScheme.primary else LocalContentColor.current
                    )
                }

            )
        }
    }
}
