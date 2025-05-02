package com.cheeruplife.core.network.di

import com.cheeruplife.core.network.retrofit.work24.Work24ServiceDataSource
import com.cheeruplife.core.network.retrofit.work24.Work24ServiceDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class NetworkModule {

    @Binds
    abstract fun bindsWork24ServiceDataSource(
        impl: Work24ServiceDataSourceImpl
    ): Work24ServiceDataSource

}