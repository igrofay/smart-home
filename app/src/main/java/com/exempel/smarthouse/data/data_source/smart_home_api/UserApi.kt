package com.exempel.smarthouse.data.data_source.smart_home_api

import com.exempel.smarthouse.data.model.user.UserData
import com.exempel.smarthouse.domain.model.user.Gender
import kotlinx.coroutines.delay
import kotlinx.datetime.LocalDate
import javax.inject.Inject

class UserApi @Inject constructor(
){
    suspend fun signIn(email: String, password: String): UserData{
        delay(1_000)
        if (email == "test@gmail.com"){
            if (password == "123456"){
                return UserData(
                    username = "Lonnie Murphy",
                    email = "test@gmail.com",
                    phone = "2647489228",
                    gender = Gender.Male,
                    dataOfBirth = "10/4/1976"
                )
            }else{
                throw Error("Неверный пароль")
            }
        }else{
            throw Exception("Почта не найдена")
        }
    }
    suspend fun signUp(email: String, username: String, password: String): UserData{
        delay(1_000)
        if (email != "test@gmail.com"){
            return UserData(
                username = username,
                email = email,
            )
        }else{
            throw Exception("Такая почта уже зарегистрирована")
        }
    }
}