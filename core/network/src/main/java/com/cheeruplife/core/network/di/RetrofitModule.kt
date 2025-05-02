package com.cheeruplife.core.network.di

import com.cheeruplife.core.data.BuildConfig
import com.cheeruplife.core.network.retrofit.work24.Work24ServiceApi
import com.cheeruplife.core.network.utils.MyXmlToJsonConverterFactory
import com.cheeruplife.core.network.utils.SeoulDataInterceptor
import com.cheeruplife.core.network.utils.SeoulDataOkhttpClient
import com.cheeruplife.core.network.utils.Work24Interceptor
import com.cheeruplife.core.network.utils.Work24OkhttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {

    @Provides
    @Singleton
    @Work24Interceptor
    fun providesWork24RequestInterceptor(): Interceptor = Interceptor {
        val url = it.request()
            .url
            .newBuilder()
            .addQueryParameter("returnType", "XML")
            .build()
        val request = it.request()
            .newBuilder()
            .url(url)
            .build()
        return@Interceptor it.proceed(request)
    }

    @Provides
    @Singleton
    @Work24OkhttpClient
    fun providesWork24OkhttpClient(
        @Work24Interceptor requestInterceptor: Interceptor,
    ): OkHttpClient {
      return OkHttpClient.Builder()
          .addInterceptor(requestInterceptor)
          .callTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
          .readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
          .connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
          .build()
    }

    @Provides
    @Singleton
    fun providesNetworkJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @Provides
    @Singleton
    fun providesJsonConverterFactory(
        json: Json,
    ): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @Singleton
    fun providesXmlConverterFactory(
        jsonConverterFactory: Converter.Factory
    ): MyXmlToJsonConverterFactory {
        return MyXmlToJsonConverterFactory(jsonConverterFactory)
    }

    @Provides
    @Singleton
    fun providesWork24Api(
        @Work24OkhttpClient okHttpClient: OkHttpClient,
        xmlConverterFactory: MyXmlToJsonConverterFactory,
    ): Work24ServiceApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(xmlConverterFactory)
            .baseUrl(BuildConfig.WORK24_BASE_URL)
            .build()
            .create(Work24ServiceApi::class.java)
    }

    @Provides
    @Singleton
    @SeoulDataInterceptor
    fun providesSeoulDataRequestInterceptor(): Interceptor = Interceptor {
        val url = it.request()
            .url
            .newBuilder()
            .addPathSegment(BuildConfig.SEOUL_AUTH_KEY)
            .addPathSegment("json")
            .build()
        val request = it.request()
            .newBuilder()
            .url(url)
            .build()
        return@Interceptor it.proceed(request)
    }

    @Provides
    @Singleton
    @SeoulDataOkhttpClient
    fun providesSeoulDataOkhttpClient(
        @SeoulDataInterceptor requestInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .callTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providesSeoulDataApi(
        @SeoulDataOkhttpClient okHttpClient: OkHttpClient,
        jsonConverterFactory: Converter.Factory
    ): Work24ServiceApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(jsonConverterFactory)
            .baseUrl(BuildConfig.SEOUL_BASE_URL)
            .build()
            .create(Work24ServiceApi::class.java)
    }

}

private val NETWORK_TIME_OUT = 10L