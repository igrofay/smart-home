package com.exempel.smarthouse.feature.authentication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.exempel.smarthouse.R
import com.exempel.smarthouse.domain.model.error.AuthenticationError
import com.exempel.smarthouse.feature.authentication.model.EventAuthentication
import com.exempel.smarthouse.feature.authentication.model.StateAuthentication
import com.exempel.smarthouse.feature.common.view_model.EventBase

@Composable
fun DataInputView(
    dataInput: StateAuthentication.DataInput,
    errorInput: AuthenticationError?,
    event: EventBase<EventAuthentication>,
) {
    DataInputBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.weight(1.2f))
            Image(
                painter = painterResource(R.drawable.logo_two),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
            )
            Text(
                text = stringResource(R.string.app_name),
                style = typography.subtitle1,
                color = Color.White,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            DataInputCard(dataInput,errorInput, event)
            Button(
                onClick = {
                          event.onEvent(EventAuthentication.Sign)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(vertical = 18.dp),
                shape = MaterialTheme.shapes.medium,
                contentPadding = PaddingValues(vertical = 16.dp),
            ) {
                Text(
                    text = if (dataInput.type == StateAuthentication.DataInput.InputType.SignUp) {
                        "New Resident"
                    } else {
                        "Enter Your House"
                    },
                )
            }
            Button(
                onClick = {
                    event.onEvent(EventAuthentication.ChangeLoginType)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(0.75f),
                shape = MaterialTheme.shapes.medium,
                contentPadding = PaddingValues(vertical = 16.dp),
            ) {
                Text(
                    text = if (dataInput.type == StateAuthentication.DataInput.InputType.SignUp) {
                        "Enter Your House"
                    } else {
                        "New Resident"
                    },
                )
            }
            Spacer(modifier = Modifier.weight(0.8f))
        }
    }
}