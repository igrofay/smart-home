package com.exempel.smarthouse.domain.model.user

import kotlinx.datetime.LocalDate


interface UserModel{
    val urlImageProfile : String
    val username: String
    val email: String
    val phone: String
    val gender: Gender
    val dataOfBirth: String
}
