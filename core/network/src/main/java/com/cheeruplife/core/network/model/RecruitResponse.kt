package com.cheeruplife.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecruitResponse(
    @SerialName("dhsOpenEmpInfoList")
    val dhsOpenEmpInfoList: DhsOpenEmpInfoList,
)

@Serializable
data class DhsOpenEmpInfoList(
    var total: Int = 0,
    var startPage: Int = 0,
    var display: Int = 0,
    @SerialName("dhsOpenEmpInfo")
    var dhsOpenEmpInfo: List<RecruitDTO> = listOf(),
)

@Serializable
data class RecruitDTO(
    var empSeqno: Long? = null,
    var empWantedTitle: String? = null,
    var empBusiNm: String? = null,
    var coClcdNm: String? = null,
    var empWantedStdt: String? = null,
    var empWantedEndt: String? = null,
    var empWantedTypeNm: String? = null,
    var regLogImgNm: String? = null,
    var empWantedHomepgDetail: String? = null,
)