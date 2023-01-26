package com.exempel.smarthouse.feature.nav.view

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.exempel.smarthouse.feature.authentication.view.AuthenticationScreen
import com.exempel.smarthouse.feature.nav.model.MainRouting
import com.exempel.smarthouse.feature.nav.model.StartRouting
import com.exempel.smarthouse.feature.launch.view.LaunchScreen

fun NavGraphBuilder.startGraph(navController: NavController) {
    navigation(
        startDestination = StartRouting.LaunchRoute.route,
        route = StartRouting.route
    ) {
        composable(StartRouting.LaunchRoute.route) {
            LaunchScreen(
                grantAccess = {
                    navController.navigate(MainRouting.route) {
                        popUpTo(
                            StartRouting.LaunchRoute.route
                        ) { inclusive = true }
                    }
                },
                needAuthentication = {
                    navController.navigate(StartRouting.AuthenticationRoute.route) {
                        popUpTo(
                            StartRouting.LaunchRoute.route
                        ) { inclusive = true }
                    }
                },
            )
        }
        composable(StartRouting.AuthenticationRoute.route) {
            AuthenticationScreen(
                grantAccess = {
                    navController.navigate(MainRouting.route) {
                        popUpTo(
                            StartRouting.AuthenticationRoute.route
                        ) { inclusive = true }
                    }
                },
            )
        }
    }
}