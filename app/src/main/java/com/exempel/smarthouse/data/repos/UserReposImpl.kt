package com.exempel.smarthouse.data.repos

import android.util.Log
import androidx.datastore.core.DataStore
import com.exempel.smarthouse.data.model.user.UserData
import com.exempel.smarthouse.domain.model.error.ErrorRequest
import com.exempel.smarthouse.domain.model.user.UserModel
import com.exempel.smarthouse.domain.repos.UserRepos
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class UserReposImpl @Inject constructor(
    private val store: DataStore<UserData?>,
): UserRepos{
    override fun getUser(): Flow<UserModel> {
        return store.data.filterNotNull()
    }

    override suspend fun singleUser(): UserModel {
        return store.data.first()
            ?: throw ErrorRequest.DataNotFound()
    }

    override suspend fun updateUser(userModel: UserModel) {
        store.updateData {
            UserData(
                email = userModel.email,
                username = userModel.username,
                phone = userModel.phone,
                gender = userModel.gender,
                dataOfBirth = userModel.dataOfBirth,
                urlImageProfile = userModel.urlImageProfile
            )
        }
    }

    override suspend fun clearUser() {
        store.updateData { null }
    }

}
