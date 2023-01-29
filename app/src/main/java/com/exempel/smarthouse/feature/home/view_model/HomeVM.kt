package com.exempel.smarthouse.feature.home.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exempel.smarthouse.domain.model.error.ErrorRequest
import com.exempel.smarthouse.domain.repos.GeocodingRepos
import com.exempel.smarthouse.feature.common.view_model.EventBase
import com.exempel.smarthouse.feature.home.model.EventHome
import com.exempel.smarthouse.feature.home.model.StateHome
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.GeoObjectTapEvent
import com.yandex.mapkit.layers.GeoObjectTapListener
import com.yandex.mapkit.map.InputListener
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectTapListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val geocodingRepos: GeocodingRepos,
) : ViewModel(), EventBase<EventHome>, InputListener {
    private val _state = mutableStateOf(StateHome())
    val state : State<StateHome> by ::_state
    private var job: Job? = null
    override fun onEvent(event: EventHome) {
        when(event){
            is EventHome.SelectedPointOnMap -> {
                job?.cancel()
                job = viewModelScope.launch {
                    try {
                        val address = geocodingRepos
                            .addressFromPoint(event.point.latitude, event.point.longitude)
                        _state.value = _state.value.copy(addressHome = address)
                    }catch (e: ErrorRequest.DataNotFound){
                        _state.value = _state.value.copy(addressHome = "Неопределено")
                    }
                }
            }

        }
    }

    override fun onMapTap(p0: Map, p1: Point) {
        onEvent(EventHome.SelectedPointOnMap(p1))
    }

    override fun onMapLongTap(p0: Map, p1: Point) {
    }
}