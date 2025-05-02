package com.cheeruplife.core.network.model.seoul


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobCafeResponse(
    @SerialName("jobCafeOpenInfo")
    val jobCafeOpenInfo: JobCafeOpenInfo,
) {
    @Serializable
    data class JobCafeOpenInfo(
        @SerialName("list_total_count")
        val listTotalCount: Int? = null,
        @SerialName("RESULT")
        val rESULT: RESULT? = null,
        @SerialName("row")
        val data: List<JobCafeDTO> = emptyList(),
    ) {
        @Serializable
        data class RESULT(
            @SerialName("CODE")
            val cODE: String? = null,
            @SerialName("MESSAGE")
            val mESSAGE: String? = null
        )
        @Serializable
        data class JobCafeDTO(
            @SerialName("APPR_MTHD_NM")
            val aPPRMTHDNM: String? = null,
            @SerialName("BASS_ADRES_CN")
            val bASSADRESCN: String? = null,
            @SerialName("CAFE_NM")
            val cAFENM: String? = null,
            @SerialName("CAFE_TYPE_NM")
            val cAFETYPENM: String? = null,
            @SerialName("FACLT_INFO1")
            val fACLTINFO1: String? = null,
            @SerialName("FACLT_INFO10")
            val fACLTINFO10: String? = null,
            @SerialName("FACLT_INFO2")
            val fACLTINFO2: String? = null,
            @SerialName("FACLT_INFO3")
            val fACLTINFO3: String? = null,
            @SerialName("FACLT_INFO4")
            val fACLTINFO4: String? = null,
            @SerialName("FACLT_INFO5")
            val fACLTINFO5: String? = null,
            @SerialName("FACLT_INFO6")
            val fACLTINFO6: String? = null,
            @SerialName("FACLT_INFO7")
            val fACLTINFO7: String? = null,
            @SerialName("FACLT_INFO8")
            val fACLTINFO8: String? = null,
            @SerialName("FACLT_INFO9")
            val fACLTINFO9: String? = null,
            @SerialName("FILE_NM")
            val fILENM: String? = null,
            @SerialName("GUGUN")
            val gUGUN: String? = null,
            @SerialName("HOLI_DD")
            val hOLIDD: String? = null,
            @SerialName("ROAD_ADRES2_CN")
            val rOADADRES2CN: String? = null,
            @SerialName("RSRV_SGGST1")
            val rSRVSGGST1: String? = null,
            @SerialName("RSRV_SGGST10")
            val rSRVSGGST10: String? = null,
            @SerialName("RSRV_SGGST2")
            val rSRVSGGST2: String? = null,
            @SerialName("RSRV_SGGST3")
            val rSRVSGGST3: String? = null,
            @SerialName("RSRV_SGGST4")
            val rSRVSGGST4: String? = null,
            @SerialName("RSRV_SGGST5")
            val rSRVSGGST5: String? = null,
            @SerialName("RSRV_SGGST6")
            val rSRVSGGST6: String? = null,
            @SerialName("RSRV_SGGST7")
            val rSRVSGGST7: String? = null,
            @SerialName("RSRV_SGGST8")
            val rSRVSGGST8: String? = null,
            @SerialName("RSRV_SGGST9")
            val rSRVSGGST9: String? = null,
            @SerialName("SMPL_INTRO")
            val sMPLINTRO: String? = null,
            @SerialName("SPACE_INFRO")
            val sPACEINFRO: String? = null,
            @SerialName("USE_DT")
            val uSEDT: String? = null
        )
    }
}