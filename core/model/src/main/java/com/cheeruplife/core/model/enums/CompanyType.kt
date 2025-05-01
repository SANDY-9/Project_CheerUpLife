package com.cheeruplife.core.model.enums

enum class CompanyType(
    val desc: String = "",
    val code: String = "",
) {
    대기업(
        desc = "대기업",
        code = "10"
    ),
    공기업(
        desc = "공기업",
        code = "20"
    ),
    공공기관(
        desc = "공공기관",
        code = "30"
    ),
    중견기업(
        desc = "중견기업",
        code = "40"
    ),
    외국계기업(
        desc = "외국계기업",
        code = "50"
    );
    companion object {
        fun toMultipleSearchCode(entries: List<CompanyType>): String {
            return entries.joinToString(separator = "|") { it.code }
        }
    }
}