package com.exempel.smarthouse.feature.profile.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.exempel.smarthouse.feature.common.view.theme.red
import com.exempel.smarthouse.feature.profile.model.EventProfile
import com.exempel.smarthouse.feature.profile.view_model.ProfileVM

@Composable
fun ProfileScreen(
    viewModel: ProfileVM = hiltViewModel(),
    needAuthentication: () -> Unit,
) {
    val state by viewModel.state
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            ProfileBar(state,viewModel)
        }
        item { Spacer(modifier = Modifier.height(28.dp)) }
        item {
            ProfileEditOptions(state,viewModel)
        }
        item {
            TextButton(
                onClick = {
                    viewModel.onEvent(EventProfile.SignOut)
                    needAuthentication.invoke()
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = red
                )
            ) {
                Text(text = "Sign Out", style = MaterialTheme.typography.body1)
            }
        }
    }
}