package com.exempel.smarthouse.feature.profile.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exempel.smarthouse.domain.model.user.UserModel
import com.exempel.smarthouse.domain.repos.UserRepos
import com.exempel.smarthouse.feature.common.view_model.EventBase
import com.exempel.smarthouse.feature.profile.model.EventProfile
import com.exempel.smarthouse.feature.profile.model.StateEditProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(
    private val userRepos: UserRepos,
) : ViewModel(), EventBase<EventProfile>{
    private var subscription: Job? = null
    private val _state = mutableStateOf<UserModel>(StateEditProfile())
    val state: State<UserModel> by::_state
    init {
        subscription = viewModelScope.launch {
            userRepos.getUser().collect{ model ->
                _state.value = model
            }
        }
    }

    override fun onEvent(event: EventProfile) {
        when(event){
            is EventProfile.ChangeImageProfile -> {
                val value = _state.value as? StateEditProfile
                    ?: userModelToStateEditProfile()
                _state.value = value.copy(urlImageProfile = event.uriImage)
            }
            EventProfile.SaveChanges -> {
                viewModelScope.launch {
                    userRepos.updateUser(_state.value)
                }
            }
            is EventProfile.InputEmail -> {
                val value = _state.value as? StateEditProfile
                    ?: userModelToStateEditProfile()
                _state.value = value.copy(email = event.value)
            }
            is EventProfile.InputPhone -> {
                val value = _state.value as? StateEditProfile
                    ?: userModelToStateEditProfile()
                _state.value = value.copy(phone = event.value.take(10))
            }
            is EventProfile.InputUsername -> {
                val value = _state.value as? StateEditProfile
                    ?: userModelToStateEditProfile()
                _state.value = value.copy(username = event.value)
            }
            is EventProfile.ChangeGender ->{
                val value = _state.value as? StateEditProfile
                    ?: userModelToStateEditProfile()
                _state.value = value.copy(gender = event.gender)
            }
            is EventProfile.InputDateOfBirth -> {
                val value = _state.value as? StateEditProfile
                    ?: userModelToStateEditProfile()
                _state.value = value.copy(dataOfBirth = event.value)
            }
            EventProfile.SignOut -> {
                viewModelScope.launch {
                    userRepos.clearUser()
                }
            }
        }
    }

    private fun userModelToStateEditProfile(): StateEditProfile{
        val model = _state.value
        return StateEditProfile(
            model.urlImageProfile,
            model.username,
            model.email,
            model.phone,
            model.gender,
            model.dataOfBirth
        )
    }

    override fun onCleared() {
        super.onCleared()
        subscription?.cancel()
    }
}