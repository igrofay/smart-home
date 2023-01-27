package com.exempel.smarthouse.domain.model.user


interface UserModel{
    val urlImageProfile : String
    val username: String
    val email: String
    val phone: String
    val gender: Gender
    val dataOfBirth: String
}
