package com.cheeruplife.core.network.retrofit.work24

import com.cheeruplife.core.network.model.EducationResponse
import com.cheeruplife.core.network.model.EventResponse
import com.cheeruplife.core.network.model.RecruitResponse

interface Work24ServiceDataSource {
    suspend fun getRecruitList(
        startPage: Int,
        display: Int,
        coClcd: String,
    ): RecruitResponse.DhsOpenEmpInfoList
    suspend fun getEventList(
        startPage: Int,
        display: Int,
        coClcd: String,
        areaCd: String,
        srchBgnDt: String,
        srchEndDt: String,
    ): EventResponse.DhsOpenEmpInfoList
    suspend fun getEducationList(
        startPage: Int,
        display: Int,
        pgmStdt: String,
    ): EducationResponse.EmpPgmSchdInviteList
}