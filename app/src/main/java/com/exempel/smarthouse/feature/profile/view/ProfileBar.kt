package com.exempel.smarthouse.feature.profile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.exempel.smarthouse.R
@Composable
fun ProfileBar(
    urlPhoto: String,
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .background(MaterialTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 32.dp)
        ) {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
            TextButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                Text(
                    text = "SAVE",
                    style = MaterialTheme.typography.body1
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Box(
            modifier = Modifier
                .size(120.dp)
        ){
            GlideImage(
                imageModel = urlPhoto,
                modifier = Modifier.fillMaxSize(),
                failure = {
                    Image(
                        painter = painterResource(R.drawable.unnamed),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            )
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(45.dp)
                    .offset(x= 10.dp, y = 10.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_camera),
                    contentDescription = null ,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}