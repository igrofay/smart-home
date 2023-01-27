package com.exempel.smarthouse.feature.home.model

import com.exempel.smarthouse.domain.model.room.Room
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class StateHome(
    val addressHome:String = "",
    val rooms: Flow<List<Room>> = flowOf(listOf())
)