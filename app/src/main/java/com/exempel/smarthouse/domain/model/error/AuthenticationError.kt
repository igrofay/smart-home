package com.exempel.smarthouse.domain.model.error

sealed class AuthenticationError : ErrorModel(){
    class EmailEnteredIncorrectly(override val message: String) : AuthenticationError()
    class UsernameEnteredIncorrectly(override val message: String) : AuthenticationError()
    class PasswordEnteredIncorrectly(override val message: String) : AuthenticationError()
}