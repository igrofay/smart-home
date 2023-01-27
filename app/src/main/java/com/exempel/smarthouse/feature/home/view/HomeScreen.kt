package com.exempel.smarthouse.feature.home.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.exempel.smarthouse.feature.home.model.EventHome
import com.exempel.smarthouse.feature.home.view_model.HomeVM
import com.exempel.smarthouse.feature.map.view.MapView

@Composable
fun HomeScreen(
    viewModel: HomeVM = hiltViewModel()
) {
    val state by viewModel.state
    var visibleDialogMap by remember {
        mutableStateOf(false)
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            HomeBar(state){
                visibleDialogMap = true
            }
        }
    }
    if(visibleDialogMap){
        Dialog(
            onDismissRequest = { visibleDialogMap = false },
        ) {
            MapView(
                modifier = Modifier.size(320.dp)
            ){ geo->
                geo.geoObject.boundingBox?.northEast?.let {
                    viewModel.onEvent(EventHome.SelectedPointOnMap(it))
                    visibleDialogMap = false
                }
                false
            }
        }
    }
}