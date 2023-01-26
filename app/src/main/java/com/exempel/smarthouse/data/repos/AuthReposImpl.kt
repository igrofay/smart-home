package com.exempel.smarthouse.data.repos

import android.content.res.Resources
import com.exempel.smarthouse.R
import com.exempel.smarthouse.data.data_source.smart_home_api.UserApi
import com.exempel.smarthouse.data.validation_str.TypeStr
import com.exempel.smarthouse.data.validation_str.ValidationStr
import com.exempel.smarthouse.domain.model.error.AuthenticationError
import com.exempel.smarthouse.domain.model.user.UserModel
import com.exempel.smarthouse.domain.repos.AuthRepos
import javax.inject.Inject


class AuthReposImpl @Inject constructor(
    private val resources: Resources,
    private val validationStr: ValidationStr,
    private val userApi: UserApi,
) : AuthRepos {
    override suspend fun signIn(email: String, password: String) : UserModel {
        if (!validationStr.execute(TypeStr.Email(email))){
            throw AuthenticationError.EmailEnteredIncorrectly(
                    resources.getString(R.string.email_entered_incorrectly)
                )
        }
        if (!validationStr.execute(TypeStr.Password(password))){
            throw AuthenticationError.PasswordEnteredIncorrectly(
                resources.getString(R.string.password_must_be_more_than_five_characters)
            )
        }
        try {
            return userApi.signIn(email, password)
        }catch (e: Exception){
            throw AuthenticationError.EmailEnteredIncorrectly(e.message!!)
        }catch (e: Error){
            throw AuthenticationError.PasswordEnteredIncorrectly(e.message!!)
        }
    }

    override suspend fun signUp(email: String, username: String, password: String) : UserModel {
        if (!validationStr.execute(TypeStr.Email(email))){
            throw AuthenticationError.EmailEnteredIncorrectly(
                resources.getString(R.string.email_entered_incorrectly)
            )
        }
        if (!validationStr.execute(TypeStr.Username(username))){
            throw AuthenticationError.UsernameEnteredIncorrectly(
                resources.getString(R.string.username_entered_incorrectly)
            )
        }
        if (!validationStr.execute(TypeStr.Password(password))){
            throw AuthenticationError.PasswordEnteredIncorrectly(
                resources.getString(R.string.password_must_be_more_than_five_characters)
            )
        }
        try {
            return userApi.signUp(email, username, password)
        }catch (e: Exception){
            throw AuthenticationError.EmailEnteredIncorrectly(e.message!!)
        }
    }

}