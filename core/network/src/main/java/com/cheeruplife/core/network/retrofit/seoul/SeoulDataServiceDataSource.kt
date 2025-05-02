package com.cheeruplife.core.network.retrofit.seoul

import com.cheeruplife.core.network.model.seoul.JobCafeResponse

interface SeoulDataServiceDataSource {
    suspend fun getJobCafeList(
        page: Int,
        size: Int,
    ): List<JobCafeResponse.JobCafeOpenInfo.JobCafeDTO>
}