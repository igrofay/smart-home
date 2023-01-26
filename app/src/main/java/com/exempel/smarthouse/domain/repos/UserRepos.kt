package com.exempel.smarthouse.domain.repos

import com.exempel.smarthouse.domain.model.user.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepos {
    fun getUser(): Flow<UserModel>
    suspend fun singleUser(): UserModel
    suspend fun updateUser(userModel: UserModel)
    suspend fun clearUser()
}