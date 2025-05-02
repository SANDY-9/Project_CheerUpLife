package com.cheeruplife.core.network.model.work24


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EducationResponse(
    @SerialName("empPgmSchdInviteList")
    val empPgmSchdInviteList: EmpPgmSchdInviteList
) {
    @Serializable
    data class EmpPgmSchdInviteList(
        @SerialName("display")
        val display: String? = null,
        @SerialName("empPgmSchdInvite")
        val empPgmSchdInvite: List<EducationDTO> = emptyList(),
        @SerialName("startPage")
        val startPage: String? = null,
        @SerialName("total")
        val total: String? = null,
    ) {
        @Serializable
        data class EducationDTO(
            @SerialName("openPlcCont")
            val openPlcCont: String? = null,
            @SerialName("openTime")
            val openTime: String? = null,
            @SerialName("openTimeClcd")
            val openTimeClcd: String? = null,
            @SerialName("operationTime")
            val operationTime: String? = null,
            @SerialName("orgNm")
            val orgNm: String? = null,
            @SerialName("pgmEndt")
            val pgmEndt: String? = null,
            @SerialName("pgmNm")
            val pgmNm: String? = null,
            @SerialName("pgmStdt")
            val pgmStdt: String? = null,
            @SerialName("pgmSubNm")
            val pgmSubNm: String? = null,
            @SerialName("pgmTarget")
            val pgmTarget: String? = null,
        )
    }
}