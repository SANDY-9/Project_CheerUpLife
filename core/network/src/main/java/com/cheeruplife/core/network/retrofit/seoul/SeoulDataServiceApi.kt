package com.cheeruplife.core.network.retrofit.seoul

import com.cheeruplife.core.data.BuildConfig
import com.cheeruplife.core.network.model.seoul.JobCafeResponse
import com.cheeruplife.core.network.model.seoul.NetworkLstResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SeoulDataServiceApi {
    @GET("${BuildConfig.SEOUL_AUTH_KEY}/json/jobCafeOpenInfo/{page}/{size}")
    suspend fun getJobCafeList(
        @Path("page") page: Int,
        @Path("size") size: Int,
    ): JobCafeResponse

    @GET("${BuildConfig.SEOUL_AUTH_KEY}/json/TnNetworkLstOpen/{page}/{size}")
    suspend fun getNetworkLst(
        @Path("page") page: Int,
        @Path("size") size: Int,
    ): NetworkLstResponse
}