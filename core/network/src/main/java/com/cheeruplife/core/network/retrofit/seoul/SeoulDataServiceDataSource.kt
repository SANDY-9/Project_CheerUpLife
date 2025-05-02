package com.cheeruplife.core.network.retrofit.seoul

import com.cheeruplife.core.network.model.seoul.JobCafeResponse
import com.cheeruplife.core.network.model.seoul.NetworkLstResponse

interface SeoulDataServiceDataSource {
    suspend fun getJobCafeList(
        page: Int,
        size: Int,
    ): List<JobCafeResponse.JobCafeOpenInfo.JobCafeDTO>
    suspend fun getNetworkLst(
        page: Int,
        size: Int,
    ): List<NetworkLstResponse.TnNetworkLstOpen.NetworkLstDTO>
}