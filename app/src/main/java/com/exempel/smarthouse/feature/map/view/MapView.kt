package com.exempel.smarthouse.feature.map.view


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.layers.GeoObjectTapEvent

@Composable
fun MapView(
    modifier: Modifier = Modifier,
    onTap: (GeoObjectTapEvent)->Boolean
) {
    val mapView = rememberMapViewWithLifeCycle().apply {
        this.map.addTapListener(onTap)
    }
    AndroidView({ mapView },modifier){

    }
}