package com.exempel.smarthouse.feature.profile.model

import com.exempel.smarthouse.domain.model.user.Gender
import java.time.LocalDate

sealed class EventProfile {
    class ChangeImageProfile(val uriImage:String): EventProfile()
    object SaveChanges : EventProfile()
    class InputUsername(val value:String): EventProfile()
    class InputEmail(val value:String): EventProfile()
    class InputPhone(val value: String): EventProfile()
    class ChangeGender(val gender: Gender): EventProfile()
    class InputDateOfBirth(val date: LocalDate):EventProfile()
    object SignOut:EventProfile()
}