package com.exempel.smarthouse.feature.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.exempel.smarthouse.R
import com.exempel.smarthouse.feature.home.model.StateHome

@Composable
fun HomeBar(
    stateHome: StateHome,
    openMap: ()->Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(180.dp)
        .background(MaterialTheme.colors.primary)
        .padding(top = 38.dp),
    ){
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = openMap,
            colors = ButtonDefaults.textButtonColors(contentColor = Color.White),
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = "Your Home",
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = Color.White.copy(0.5f)
            )
            Text(
                text = stateHome.addressHome,
                style = MaterialTheme.typography.body2,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = "ROOMS",
                    color = Color.White,
                    style = MaterialTheme.typography.subtitle2,
                )
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(8.dp)
                        .width(120.dp)
                        .background(MaterialTheme.colors.secondary)
                )
            }
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .size(34.dp)
                    .offset(x= (-12).dp, y= (-8).dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            }
        }
    }
}