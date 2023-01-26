package com.exempel.smarthouse.feature.app

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exempel.smarthouse.R
import com.exempel.smarthouse.feature.authentication.view.AuthenticationScreen
import com.exempel.smarthouse.feature.common.view.dimmer.Dimmer
import com.exempel.smarthouse.feature.common.view.theme.SmartHouseTheme
import com.exempel.smarthouse.feature.common.view.theme.darkYellow
import com.exempel.smarthouse.feature.common.view.vertical_regulator.VerticalRegulator
import com.exempel.smarthouse.feature.nav.view.InitNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContent {
            SmartHouseTheme(false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colors.background
                ) {
                   InitNav()
                }
            }
        }
    }
}

