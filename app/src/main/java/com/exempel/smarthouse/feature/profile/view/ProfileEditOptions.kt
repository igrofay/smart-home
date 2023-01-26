package com.exempel.smarthouse.feature.profile.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.exempel.smarthouse.domain.model.user.Gender
import com.exempel.smarthouse.domain.model.user.UserModel
import com.exempel.smarthouse.feature.common.view.visual_transformation.PhoneVisualTransformation
import com.exempel.smarthouse.feature.common.view_model.EventBase
import com.exempel.smarthouse.feature.profile.model.EventProfile

@Composable
fun ProfileEditOptions(
    userModel: UserModel,
    event: EventBase<EventProfile>,
) {
    val styleTextField = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
        textColor = MaterialTheme.colors.primary,
        cursorColor = Color.Black,
        disabledLabelColor = Color.Black,
        focusedLabelColor = Color.Black,
        unfocusedLabelColor = Color.Black,
        unfocusedIndicatorColor = Color.Black,
        focusedIndicatorColor = Color.Black,
        disabledIndicatorColor = Color.Black,
        disabledTextColor = MaterialTheme.colors.primary,
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        TextField(
            value = userModel.username,
            onValueChange = { event.onEvent(EventProfile.InputUsername(it)) },
            label = {
                Text(
                    "Username",
                    style = MaterialTheme
                        .typography.body1.copy(fontWeight = FontWeight.Bold),
                )
            },
            textStyle = MaterialTheme.typography.subtitle1,
            colors = styleTextField,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f),
//            isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
        )
        TextField(
            value = userModel.email,
            onValueChange = { event.onEvent(EventProfile.InputEmail(it)) },
            label = {
                Text(
                    "Email",
                    style =  MaterialTheme
                        .typography.body1.copy(fontWeight = FontWeight.Bold),
                )
            },
            textStyle = MaterialTheme.typography.subtitle1,
            colors = styleTextField,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
            ),
//            isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
        )
        TextField(
            value = userModel.phone,
            onValueChange = { event.onEvent(EventProfile.InputPhone(it)) },
            label = {
                Text(
                    "Phone",
                    style = MaterialTheme
                        .typography.body1.copy(fontWeight = FontWeight.Bold),
                )
            },
            textStyle =  MaterialTheme.typography.subtitle1,
            colors = styleTextField,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
            ),
            visualTransformation = PhoneVisualTransformation(
                mask = "(000) 000 00 00",
                maskNumber = '0',
            )
//            isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
        )
        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier.clickable { expanded = true }
        ){
            TextField(
                value = userModel.gender.name,
                onValueChange = {},
                label = {
                    Text(
                        "Phone",
                        style = MaterialTheme
                            .typography.body1.copy(fontWeight = FontWeight.Bold),
                    )
                },
                textStyle =  MaterialTheme.typography.subtitle1,
                colors = styleTextField,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f),
                readOnly = true,
                enabled = false
//            isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                for (i in Gender.values()){
                    Text(
                        text = i.name,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .width(120.dp)
                            .clickable {
                                expanded = false
                                event.onEvent(EventProfile.ChangeGender(i))
                            }
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        }
        TextField(
            value = userModel.dataOfBirth,
            onValueChange = { event.onEvent(EventProfile.InputDateOfBirth(it)) },
            label = {
                Text(
                    "Date Of Birth",
                    style = MaterialTheme
                        .typography.body1.copy(fontWeight = FontWeight.Bold),
                )
            },
            textStyle = MaterialTheme.typography.subtitle1,
            colors = styleTextField,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
//            isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
        )
    }
}