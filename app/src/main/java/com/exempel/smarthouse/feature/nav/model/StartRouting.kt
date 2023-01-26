package com.exempel.smarthouse.feature.nav.model

sealed class StartRouting(val route: String){
    companion object{
        const val route = "start"
    }
    object LaunchRoute: StartRouting("launch")
    object AuthenticationRoute: StartRouting("authentication")
}