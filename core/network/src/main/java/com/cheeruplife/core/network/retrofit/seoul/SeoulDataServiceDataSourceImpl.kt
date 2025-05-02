package com.cheeruplife.core.network.retrofit.seoul

import com.cheeruplife.core.network.model.seoul.JobCafeResponse
import com.cheeruplife.core.network.model.seoul.NetworkLstResponse
import javax.inject.Inject

class SeoulDataServiceDataSourceImpl @Inject constructor(
    private val api: SeoulDataServiceApi,
) : SeoulDataServiceDataSource {

    override suspend fun getJobCafeList(
        page: Int,
        size: Int,
    ): List<JobCafeResponse.JobCafeOpenInfo.JobCafeDTO> {
        return api.getJobCafeList(
            page = page,
            size = size,
        ).jobCafeOpenInfo.data
    }

    override suspend fun getNetworkLst(
        page: Int,
        size: Int
    ): List<NetworkLstResponse.TnNetworkLstOpen.NetworkLstDTO> {
        return api.getNetworkLst(
            page = page,
            size = size,
        ).tnNetworkLstOpen.data
    }
}