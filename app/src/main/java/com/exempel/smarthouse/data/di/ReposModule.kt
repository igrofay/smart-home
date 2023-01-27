package com.exempel.smarthouse.data.di

import com.exempel.smarthouse.data.repos.AuthReposImpl
import com.exempel.smarthouse.data.repos.GeocodingReposImpl
import com.exempel.smarthouse.data.repos.UserReposImpl
import com.exempel.smarthouse.domain.repos.AuthRepos
import com.exempel.smarthouse.domain.repos.GeocodingRepos
import com.exempel.smarthouse.domain.repos.UserRepos
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ReposModule {

    @Binds
    @Singleton
    abstract fun userRepos(weatherReposImpl: UserReposImpl) : UserRepos

    @Binds
    abstract fun authRepos(authRepos: AuthReposImpl): AuthRepos


    @Binds
    abstract fun geocodingRepos(geocodingRepos: GeocodingReposImpl): GeocodingRepos
}