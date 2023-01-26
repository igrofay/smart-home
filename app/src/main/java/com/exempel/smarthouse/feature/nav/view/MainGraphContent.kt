package com.exempel.smarthouse.feature.nav.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.exempel.smarthouse.feature.nav.model.MainRouting
import com.exempel.smarthouse.feature.profile.view.ProfileScreen

@Composable
fun MainGraphContent(
    needAuthentication: () -> Unit,
) {
    val nav = rememberNavController()
    Scaffold(
        bottomBar = {
           Column {
               Divider()
               Row(
                   horizontalArrangement = Arrangement.SpaceAround,
                   verticalAlignment = Alignment.CenterVertically,
                   modifier = Modifier
                       .fillMaxWidth()
                       .background(Color.White)
                       .padding(vertical = 12.dp)
               ) {
                   val navBackStackEntry by nav.currentBackStackEntryAsState()
                   val currentDestination = navBackStackEntry?.destination
                   MainRouting.values.forEach { item ->
                       ItemOfBottomNavBar(
                           icon = item.icon,
                           label = item.name,
                           selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                       ) {
                           nav.navigate(item.route) {
                               popUpTo(nav.graph.findStartDestination().id) {
                                   saveState = true
                               }
                               launchSingleTop = true
                               restoreState = true
                           }
                       }
                   }
               }
           }
        }
    ) {
        NavHost(
            navController = nav,
            startDestination = MainRouting.HomeRoute.route,
            modifier = Modifier.padding(it)
        ) {
            composable(MainRouting.HomeRoute.route) {

            }
            composable(MainRouting.Statics.route) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Under reconstruction",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
            composable(MainRouting.Routines.route) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Under reconstruction",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
            composable(MainRouting.Setting.route) {
                ProfileScreen(needAuthentication = needAuthentication)
            }
        }
    }
}