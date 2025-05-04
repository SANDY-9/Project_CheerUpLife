package com.cheeruplife.core.calendar.model

import com.cheeruplife.core.calendar.utils.CalendarUtils
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.enums.DayOfWeek

typealias Week = List<Date>

data class Calendar(
    val days: List<Week>,
    val month: Int,
    val year: Int,
) {
    companion object {
        fun create(
            year: Int,
            month: Int,
        ): Calendar {
            return Calendar(
                year = year,
                month = month,
                days = CalendarUtils.getMonthByWeek(year, month)
                    .map { week ->
                        week.map { localDate ->
                            Date(
                                year = localDate.year,
                                month = localDate.monthValue,
                                day = localDate.dayOfMonth,
                                dayOfWeek = DayOfWeek.get(localDate.dayOfWeek.value),
                            )
                        }
                    }
            )
        }

        fun List<Week>.findWeekIndex(date: Date): Int {
            val weekIndex = indexOfFirst { week ->
                week.find { it == date } != null
            }
            return if(weekIndex == -1) 0 else weekIndex
        }
    }
}
