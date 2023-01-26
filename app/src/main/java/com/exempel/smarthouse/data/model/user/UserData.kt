package com.exempel.smarthouse.data.model.user

import com.exempel.smarthouse.domain.model.user.Gender
import com.exempel.smarthouse.domain.model.user.UserModel
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    override val username: String = "",
    override val email: String = "",
    override val phone: String = "",
    override val gender: Gender = Gender.Male,
    override val dataOfBirth: LocalDate = Clock.System
        .todayIn(TimeZone.currentSystemDefault()),
    override val urlImageProfile: String = "",
) : UserModel