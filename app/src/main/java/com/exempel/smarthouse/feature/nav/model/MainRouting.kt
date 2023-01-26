package com.exempel.smarthouse.feature.nav.model

import androidx.annotation.DrawableRes
import com.exempel.smarthouse.R

sealed class MainRouting(val route: String, val name: String, @DrawableRes val icon: Int){
    companion object{
        const val route = "main"
        val values by lazy {
            listOf(HomeRoute, Statics, Routines, Setting,)
        }
    }
    object HomeRoute:MainRouting("home", "Home", R.drawable.ic_home)
    object Statics:MainRouting("statics", "Statics", R.drawable.ic_statics)
    object Routines:MainRouting("routines", "Routines", R.drawable.ic_routines)
    object Setting:MainRouting("setting", "Setting", R.drawable.ic_settng)
}
