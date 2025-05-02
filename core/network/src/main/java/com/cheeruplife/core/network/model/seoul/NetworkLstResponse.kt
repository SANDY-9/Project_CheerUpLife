package com.cheeruplife.core.network.model.seoul


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkLstResponse(
    @SerialName("TnNetworkLstOpen")
    val tnNetworkLstOpen: TnNetworkLstOpen
) {
    @Serializable
    data class TnNetworkLstOpen(
        @SerialName("list_total_count")
        val listTotalCount: Int? = null,
        @SerialName("RESULT")
        val rESULT: RESULT? = null,
        @SerialName("row")
        val data: List<NetworkLstDTO> = emptyList(),
    ) {
        @Serializable
        data class RESULT(
            @SerialName("CODE")
            val cODE: String? = null,
            @SerialName("MESSAGE")
            val mESSAGE: String? = null
        )
        @Serializable
        data class NetworkLstDTO(
            @SerialName("ADDR_TEL")
            val aDDRTEL: String? = null,
            @SerialName("REGIST_DT_HM")
            val rEGISTDTHM: String? = null,
            @SerialName("SITE_ADDR")
            val sITEADDR: String? = null,
            @SerialName("SITE_GUBUN")
            val sITEGUBUN: String? = null,
            @SerialName("SITE_NM")
            val sITENM: String? = null,
            @SerialName("UPDT_DT_HM")
            val uPDTDTHM: String? = null,
        )
    }
}