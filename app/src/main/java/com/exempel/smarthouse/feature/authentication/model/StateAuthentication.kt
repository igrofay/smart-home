package com.exempel.smarthouse.feature.authentication.model

sealed class StateAuthentication{
    object Authorized : StateAuthentication()
    data class DataInput(
        val email: String = "",
        val password: String = "",
        val type: InputType = InputType.SignUp,
        val username: String = "",
    ): StateAuthentication() {
        enum class InputType{ SignUp, SignIn, }
    }
}
