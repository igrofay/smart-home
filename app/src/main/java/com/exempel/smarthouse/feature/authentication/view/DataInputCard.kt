package com.exempel.smarthouse.feature.authentication.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.exempel.smarthouse.domain.model.error.AuthenticationError
import com.exempel.smarthouse.feature.authentication.model.EventAuthentication
import com.exempel.smarthouse.feature.authentication.model.StateAuthentication
import com.exempel.smarthouse.feature.common.view_model.EventBase

@Composable
fun DataInputCard(
    dataInput: StateAuthentication.DataInput,
    errorInput: AuthenticationError?,
    event: EventBase<EventAuthentication>,
) {
    val styleTextField = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
        textColor = Color.White,
        cursorColor =  Color.White,
        disabledLabelColor = Color.White,
        focusedLabelColor = Color.White,
        unfocusedLabelColor = Color.White,
        unfocusedIndicatorColor = Color.White,
        focusedIndicatorColor = Color.White,
        disabledIndicatorColor = Color.White,
    )
    Column(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .border(1.dp, Color.Gray.copy(0.3f), MaterialTheme.shapes.medium)
            .drawWithContent {
                drawRect(
                    color = Color.White.copy(.4f),
                    size = size,
                    blendMode = BlendMode.SrcOver
                )
                drawContent()
            }
            .padding(vertical = 24.dp, horizontal = 12.dp)
    ) {
        TextField(
            value = dataInput.email,
            onValueChange = { event.onEvent(EventAuthentication.InputEmail(it)) },
            label = {
                Text(
                    "E-mail",
                    style = MaterialTheme.typography.body1
                )
            },
            textStyle =  MaterialTheme.typography.body1,
            colors = styleTextField,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(0.9f),
            isError = errorInput is AuthenticationError.EmailEnteredIncorrectly,
        )
        AnimatedVisibility(
            visible = dataInput.type == StateAuthentication.DataInput.InputType.SignUp
        ) {
            TextField(
                value = dataInput.username,
                onValueChange = { event.onEvent(EventAuthentication.InputUsername(it)) },
                label = {
                    Text(
                        "Name",
                        style = MaterialTheme.typography.body1
                    )
                },
                textStyle =  MaterialTheme.typography.body1,
                colors = styleTextField,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.9f),
                isError = errorInput is AuthenticationError.UsernameEnteredIncorrectly,
            )
        }
        TextField(
            value = dataInput.password,
            onValueChange = { event.onEvent(EventAuthentication.InputPassword(it)) },
            label = {
                Text(
                    "Password",
                    style = MaterialTheme.typography.body1
                )
            },
            textStyle =  MaterialTheme.typography.body1,
            colors = styleTextField,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(0.9f),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
            ),
            visualTransformation = PasswordVisualTransformation(mask = '▌'),
            isError = errorInput is AuthenticationError.PasswordEnteredIncorrectly,
        )
    }
}