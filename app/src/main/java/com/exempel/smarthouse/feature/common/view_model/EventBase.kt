package com.exempel.smarthouse.feature.common.view_model

interface EventBase<T>{
    fun onEvent(event: T)
}