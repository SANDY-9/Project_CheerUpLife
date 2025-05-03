package com.cheeruplife.core.model.enums

enum class DayOfWeek(
    val dayOfWeek: Int = 0,
    val desc: String = "",
    val fullName: String = "",
) {
    SUNDAY(
        desc = "일",
        fullName = "일요일",
        dayOfWeek = 0,
    ),
    MONDAY(
        desc = "월",
        fullName = "월요일",
        dayOfWeek = 1,
    ),
    TUESDAY(
        desc = "화",
        fullName = "화요일",
        dayOfWeek = 2,
    ),
    WEDNESDAY(
        desc = "수",
        fullName = "수요일",
        dayOfWeek = 3,
    ),
    THURSDAY(
        desc = "월",
        fullName = "목요일",
        dayOfWeek = 4,
    ),
    FRIDAY(
        desc = "금",
        fullName = "금요일",
        dayOfWeek = 5,
    ),
    SATURDAY(
        desc = "토",
        fullName = "토요일",
        dayOfWeek = 6,
    );

    companion object {
        fun get(dayOfWeek: Int): DayOfWeek {
            return DayOfWeek.entries.find { it.dayOfWeek == dayOfWeek } ?: SUNDAY
        }
    }
}