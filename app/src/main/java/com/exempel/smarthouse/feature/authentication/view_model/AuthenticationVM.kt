package com.exempel.smarthouse.feature.authentication.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exempel.smarthouse.domain.model.error.ErrorModel
import com.exempel.smarthouse.domain.use_case.auth.SignInUseCase
import com.exempel.smarthouse.domain.use_case.auth.SignUpUseCase
import com.exempel.smarthouse.feature.authentication.model.EventAuthentication
import com.exempel.smarthouse.feature.authentication.model.StateAuthentication
import com.exempel.smarthouse.feature.authentication.model.StateAuthentication.DataInput.InputType.*
import com.exempel.smarthouse.feature.common.view_model.EventBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationVM @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase,
) : ViewModel(), EventBase<EventAuthentication>{
    private val _state = mutableStateOf<StateAuthentication>(StateAuthentication.DataInput())
    val state: State<StateAuthentication> by ::_state
    private val _stateErrorMessage = mutableStateOf<ErrorModel?>(null)
    val stateErrorMessage : State<ErrorModel?> by ::_stateErrorMessage

    override fun onEvent(event: EventAuthentication) {
        when(event){
            is EventAuthentication.ChangeLoginType -> {
                val value = (_state.value as? StateAuthentication.DataInput) ?: return
                _state.value = when(value.type){
                    SignUp -> value.copy(type = SignIn)
                    SignIn -> value.copy(type = SignUp)
                }
            }
            is EventAuthentication.InputEmail -> {
                val value = (_state.value as? StateAuthentication.DataInput) ?: return
                _state.value = value.copy(email = event.value)
            }
            is EventAuthentication.InputPassword -> {
                val value = (_state.value as? StateAuthentication.DataInput) ?: return
                _state.value = value.copy(password = event.value)
            }
            is EventAuthentication.InputUsername -> {
                val value = (_state.value as? StateAuthentication.DataInput) ?: return
                _state.value = value.copy(username = event.value)
            }
            EventAuthentication.Sign -> viewModelScope.launch { sign() }
        }
    }

    private suspend fun sign(){
        val value = (_state.value as? StateAuthentication.DataInput) ?: return
        when( value.type){
            SignUp -> signUpUseCase
                .execute(value.email, value.username, value.password)
            SignIn -> signInUseCase
                .execute(value.email, value.password)
        }.onSuccess {
            Log.e("v>>", "2")
            _state.value = StateAuthentication.Authorized
        }.onFailure(::error)
    }

    private fun error(e: Throwable){
        when(e){
            is ErrorModel ->{
                _stateErrorMessage.value = e
            }
            else -> Log.e("AuthenticationVM::", e.toString())
        }
    }

}