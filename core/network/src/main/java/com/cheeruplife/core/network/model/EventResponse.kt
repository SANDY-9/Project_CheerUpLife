package com.cheeruplife.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventResponse(
    val dhsOpenEmpInfoList: DhsOpenEmpInfoList,
) {
    @Serializable
    data class DhsOpenEmpInfoList(
        @SerialName("dhsOpenEmpInfo")
        val dhsOpenEmpInfo: List<EventDTO> = emptyList(),
        val display: Int = 0,
        val startPage: Int = 0,
        val total: Int = 0,
    ) {
        @Serializable
        data class EventDTO(
            val coClcdNm: String? = null,
            val empBusiNm: String? = null,
            val empSeqno: String? = null,
            val empWantedEndt: String? = null,
            val empWantedHomepgDetail: String? = null,
            val empWantedMobileUrl: String? = null,
            val empWantedStdt: String? = null,
            val empWantedTitle: String? = null,
            val empWantedTypeNm: String? = null,
            val regLogImgNm: String? = null,
        )
    }
}