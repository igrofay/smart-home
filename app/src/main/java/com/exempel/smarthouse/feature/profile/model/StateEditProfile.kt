package com.exempel.smarthouse.feature.profile.model

import com.exempel.smarthouse.domain.model.user.Gender
import com.exempel.smarthouse.domain.model.user.UserModel

data class StateEditProfile(
    override val urlImageProfile: String = "",
    override val username: String ="",
    override val email: String= "",
    override val phone: String = "",
    override val gender: Gender = Gender.Male,
    override val dataOfBirth: String = ""
) : UserModel