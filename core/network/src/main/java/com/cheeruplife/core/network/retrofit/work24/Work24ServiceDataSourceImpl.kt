package com.cheeruplife.core.network.retrofit.work24

import com.cheeruplife.core.data.BuildConfig
import com.cheeruplife.core.network.model.DhsOpenEmpInfoList
import javax.inject.Inject

internal class Work24ServiceDataSourceImpl @Inject constructor(
    private val api: Work24ServiceApi,
) : Work24ServiceDataSource {
    override suspend fun getRecruitList(
        startPage: Int,
        display: Int,
        coClcd: String
    ): DhsOpenEmpInfoList {
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

    companion object {
        private const val CALL_TYPE_LIST = "L"
    }
}