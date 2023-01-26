package com.exempel.smarthouse.domain.repos

import com.exempel.smarthouse.domain.model.user.UserModel

interface AuthRepos {
    suspend fun signIn(email: String, password:String) : UserModel
    suspend fun signUp(email: String, username: String, password:String) : UserModel
}