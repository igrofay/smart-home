package com.exempel.smarthouse.data.data_source.serializer.user_data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.exempel.smarthouse.data.model.user.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object UserDataSerializer : Serializer<UserData?> {
    const val nameFile = "user_data.preferences_pb"
    override val defaultValue: UserData? = null

    override suspend fun readFrom(input: InputStream): UserData {
        try {
            return Json.decodeFromString(
                UserData.serializer(), input.readBytes().decodeToString()
            )
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Unable to read UserData", exception)
        }
    }

    override suspend fun writeTo(t: UserData?, output: OutputStream) {
        withContext(Dispatchers.IO) {
            if (t == null){
                output.close()
            }else{
                output.write(
                    Json.encodeToString(UserData.serializer(), t)
                        .encodeToByteArray()
                )
            }
        }
    }
}