package com.exempel.smarthouse.feature.nav.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exempel.smarthouse.feature.nav.model.MainRouting
import com.exempel.smarthouse.feature.nav.model.StartRouting

@Composable
fun InitNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = StartRouting.route
    ){
        startGraph(navController)
        composable(MainRouting.route){
            MainGraphContent()
        }
    }
}