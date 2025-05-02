package com.cheeruplife.core.network.retrofit.work24

import com.cheeruplife.core.network.model.DhsOpenEmpInfoList

interface Work24ServiceDataSource {
    suspend fun getRecruitList(
        startPage: Int,
        display: Int,
        coClcd: String,
    ): DhsOpenEmpInfoList
}