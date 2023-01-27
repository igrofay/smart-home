package com.exempel.smarthouse.feature.profile.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.exempel.smarthouse.R
import com.exempel.smarthouse.domain.model.user.UserModel
import com.exempel.smarthouse.feature.common.view_model.EventBase
import com.exempel.smarthouse.feature.profile.model.EventProfile
import com.exempel.smarthouse.feature.profile.model.StateEditProfile

@Composable
fun ProfileBar(
    userModel: UserModel,
    event:EventBase<EventProfile>,
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult ={ uri: Uri? -> uri?.let { uriIsNotNull->
            event.onEvent(EventProfile.ChangeImageProfile(uriIsNotNull.toString()))
        } }
    )
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .background(MaterialTheme.colors.primary)
        .padding(top = 38.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
            TextButton(
                onClick = { event.onEvent(EventProfile.SaveChanges) },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    disabledContentColor = Color.White.copy(0.5f)
                ),
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                enabled = userModel is StateEditProfile,

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
                imageModel = userModel.urlImageProfile,
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
                onClick = { launcher.launch("image/*") },
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