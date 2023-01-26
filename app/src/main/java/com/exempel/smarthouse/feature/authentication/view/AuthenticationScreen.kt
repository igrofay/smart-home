package com.exempel.smarthouse.feature.authentication.view

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.exempel.smarthouse.domain.model.error.AuthenticationError
import com.exempel.smarthouse.feature.authentication.model.StateAuthentication
import com.exempel.smarthouse.feature.authentication.view_model.AuthenticationVM

@Composable
fun AuthenticationScreen(
    grantAccess: () -> Unit,
    viewModel: AuthenticationVM = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    val error = viewModel.stateErrorMessage.value
    LaunchedEffect(error){
        viewModel.stateErrorMessage
            .value?.message?.let { message ->
                scaffoldState.snackbarHostState.showSnackbar(message)
            }
    }
    Scaffold(
        scaffoldState = scaffoldState
    ) {
        when(
            val state = viewModel.state.value
        ){
            StateAuthentication.Authorized -> LaunchedEffect(Unit) { grantAccess() }
            is StateAuthentication.DataInput -> DataInputView(
                state,
                error as? AuthenticationError,
                viewModel,
            )
        }
    }
}