package com.cheeruplife.core.network.di

import com.cheeruplife.core.data.BuildConfig
import com.cheeruplife.core.network.retrofit.work24.Work24ServiceApi
import com.cheeruplife.core.network.utils.MyXmlToJsonConverterFactory
import com.cheeruplife.core.network.utils.Work24Interceptor
import com.cheeruplife.core.network.utils.Work24OkhttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
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
    fun providesOkhttpClient(
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
    fun providesXmlConverterFactory(
        json: Json,
    ): MyXmlToJsonConverterFactory {
        return MyXmlToJsonConverterFactory(json)
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

}

private val NETWORK_TIME_OUT = 10L