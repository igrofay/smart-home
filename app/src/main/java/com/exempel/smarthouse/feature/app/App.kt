package com.exempel.smarthouse.feature.app

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application(){
    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("a891bea6-dcfb-41c7-84a8-f7bfb9aa1883")
    }
}