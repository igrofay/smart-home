package com.exempel.smarthouse.feature.common.view.dimmer

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class DimmerColors(
    val mainColor: Color,
    val strokeColor: Color,
    val areaLimitationColor: Color,
    val dimmerColor: Color,
    val lineColor: Color,
    val textColor: Color
){
    companion object{
        @Composable
        fun default() = DimmerColors(
            MaterialTheme.colors.secondary,
            Color.White,
            Color(0xFFF2F2F2),
            Color(0xFFEEF2F5),
            Color(0xFFCBCBCB),
            Color.Black
        )
    }
}