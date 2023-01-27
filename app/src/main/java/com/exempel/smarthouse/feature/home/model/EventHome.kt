package com.exempel.smarthouse.feature.home.model

import com.yandex.mapkit.geometry.Point

sealed class EventHome {
    class SelectedPointOnMap(val point: Point) : EventHome()
}