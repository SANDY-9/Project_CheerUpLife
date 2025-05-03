package com.cheeruplife.core.model

import com.cheeruplife.core.model.enums.DayOfWeek
import java.time.LocalDate

data class Date(
    val year: Int,
    val month: Int,
    val day: Int,
    val dayOfWeek: DayOfWeek,
    val isToday: Boolean = isToday(year, month, day),
    val isHoliday: Boolean = false,
    val holiday: String = "",
) {
    companion object {
        fun isToday(year: Int, month: Int, day: Int): Boolean {
            val today = LocalDate.now()
            return today.year == year && today.monthValue == month && today.dayOfMonth == day
        }
    }
}