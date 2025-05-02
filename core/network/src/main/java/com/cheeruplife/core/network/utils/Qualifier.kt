package com.cheeruplife.core.network.utils

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class Work24Interceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class Work24OkhttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SeoulDataInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SeoulDataOkhttpClient