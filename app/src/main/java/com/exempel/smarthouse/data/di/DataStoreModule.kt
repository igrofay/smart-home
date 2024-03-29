package com.exempel.smarthouse.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.ExperimentalMultiProcessDataStore
import androidx.datastore.core.MultiProcessDataStoreFactory
import com.exempel.smarthouse.data.model.user.UserData
import com.exempel.smarthouse.data.data_source.serializer.user_data.UserDataSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    @OptIn(ExperimentalMultiProcessDataStore::class)
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<UserData?> =
        MultiProcessDataStoreFactory.create(
            serializer = UserDataSerializer,
            produceFile = {
                File("${context.cacheDir.path}/${UserDataSerializer.nameFile}")
            }
        )
}