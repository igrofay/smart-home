package com.exempel.smarthouse.feature.map.view


import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.layers.GeoObjectTapEvent
import com.yandex.mapkit.layers.GeoObjectTapListener
import com.yandex.mapkit.mapview.MapView


@Composable
fun MapView(
    modifier: Modifier = Modifier,
    map: (MapView)-> Unit
) {
    val mapView = rememberMapViewWithLifeCycle()
    AndroidView(
        { mapView },
        modifier,
        map
    )
}