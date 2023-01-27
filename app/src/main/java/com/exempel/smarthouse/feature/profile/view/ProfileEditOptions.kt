package com.exempel.smarthouse.feature.profile.view

import android.util.Log
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
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState

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
        verticalArrangement = Arrangement.spacedBy(18.dp)
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
                mask = "(000)-000-0000",
                maskNumber = '0',
            )
//            isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
        )
        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
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
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable { expanded = true },
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
        val dialogState = rememberMaterialDialogState()
        TextField(
            value = userModel.dataOfBirth,
            onValueChange = {},
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
            modifier = Modifier.fillMaxWidth(0.9f).clickable { dialogState.show() },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            readOnly = true,
            enabled = false
//            isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
        )
        MaterialDialog(
            dialogState = dialogState,
            buttons = {
                positiveButton("Ok")
                negativeButton("Cancel")
            }
        ) {
            datepicker { date ->
                event.onEvent(EventProfile.InputDateOfBirth(date))
            }
        }

    }
}