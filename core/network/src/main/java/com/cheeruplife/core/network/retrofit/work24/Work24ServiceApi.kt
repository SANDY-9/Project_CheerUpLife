package com.cheeruplife.core.network.retrofit.work24

import com.cheeruplife.core.network.model.EducationResponse
import com.cheeruplife.core.network.model.EventResponse
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

    @GET("callOpenApiSvcInfo210L11.do")
    suspend fun getEventList(
        @Query("authKey") authKey: String,
        @Query("callTp") callTp: String,
        @Query("startPage") startPage: Int,
        @Query("display") display: Int,
        @Query("coClcd") coClcd: String,
        @Query("areaCd") areaCd: String,
        @Query("srchBgnDt") srchBgnDt: String,
        @Query("srchEndDt") srchEndDt: String,
    ): EventResponse

    @GET("callOpenApiSvcInfo217L01.do")
    suspend fun getEducationList(
        @Query("authKey") authKey: String,
        @Query("startPage") startPage: Int,
        @Query("display") display: Int,
        @Query("pgmStdt") srchBgnDt: String,
    ): EducationResponse
}
