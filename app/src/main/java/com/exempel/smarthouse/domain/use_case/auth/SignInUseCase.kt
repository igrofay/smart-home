package com.exempel.smarthouse.domain.use_case.auth

import com.exempel.smarthouse.domain.repos.AuthRepos
import com.exempel.smarthouse.domain.repos.UserRepos
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepos: AuthRepos,
    private val userRepos: UserRepos,
) {
    suspend fun execute(email:String, password: String) = runCatching {
        val model = authRepos.signIn(email, password)
        userRepos.updateUser(model)
    }
}