package com.cheeruplife.core.network.retrofit.work24

import com.cheeruplife.core.data.BuildConfig
import com.cheeruplife.core.network.model.EventResponse
import com.cheeruplife.core.network.model.RecruitResponse
import javax.inject.Inject

internal class Work24ServiceDataSourceImpl @Inject constructor(
    private val api: Work24ServiceApi,
) : Work24ServiceDataSource {
    override suspend fun getRecruitList(
        startPage: Int,
        display: Int,
        coClcd: String
    ): RecruitResponse.DhsOpenEmpInfoList {
        val authKey = BuildConfig.WORK24_AUTH_KEY_REQRUIT
        val callTp = CALL_TYPE_LIST
        return api.getRecruitList(
            authKey = authKey,
            callTp = callTp,
            startPage = startPage,
            display = display,
            coClcd = coClcd,
        ).dhsOpenEmpInfoList
    }

    override suspend fun getEventList(
        startPage: Int,
        display: Int,
        coClcd: String,
        areaCd: String,
        srchBgnDt: String,
        srchEndDt: String,
    ): EventResponse.DhsOpenEmpInfoList {
        val authKey = BuildConfig.WORK24_AUTH_KEY_EVENT
        val callTp = CALL_TYPE_LIST
        return api.getEventList(
            authKey = authKey,
            callTp = callTp,
            startPage = startPage,
            display = display,
            coClcd = coClcd,
            areaCd = areaCd,
            srchBgnDt = srchBgnDt,
            srchEndDt = srchEndDt,
        ).dhsOpenEmpInfoList
    }

    companion object {
        private const val CALL_TYPE_LIST = "L" // 목록

    }
}