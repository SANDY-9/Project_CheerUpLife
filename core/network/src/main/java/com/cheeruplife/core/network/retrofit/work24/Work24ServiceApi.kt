package com.cheeruplife.core.network.retrofit.work24

import com.cheeruplife.core.network.model.RecruitResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Work24ServiceApi {
    @GET("callOpenApiSvcInfo210L21.do")
    suspend fun getRecruitList(
        @Query("authKey") authKey: String,
        @Query("callTp") callTp: String,
        @Query("startPage") startPage: Int,
        @Query("display") display: Int,
        @Query("coClcd") coClcd: String,
    ): RecruitResponse
}
