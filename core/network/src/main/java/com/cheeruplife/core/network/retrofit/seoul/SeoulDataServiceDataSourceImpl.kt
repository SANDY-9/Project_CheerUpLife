package com.cheeruplife.core.network.retrofit.seoul

import com.cheeruplife.core.network.model.seoul.JobCafeResponse
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
}