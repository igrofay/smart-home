package com.exempel.smarthouse.feature.profile.model

import com.exempel.smarthouse.domain.model.user.Gender
import com.exempel.smarthouse.domain.model.user.UserModel
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn

data class StateEditProfile(
    override val urlImageProfile: String = "",
    override val username: String ="",
    override val email: String= "",
    override val phone: String = "",
    override val gender: Gender = Gender.Male,
    override val dataOfBirth: String = ""
) : UserModel