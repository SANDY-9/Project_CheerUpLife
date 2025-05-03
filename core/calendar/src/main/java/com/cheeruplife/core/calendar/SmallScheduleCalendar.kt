package com.cheeruplife.core.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.model.Calendar
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.Schedule

@Composable
fun LifeSmallScheduleCalendar(
    weekIndex: Int,
    selectDate: Date?,
    week: List<Date>,
    schedule: Map<Date, List<Schedule>>,
    onDateSelect: (Date, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectEvent = remember {
        { date: Date -> onDateSelect(date, weekIndex) }
    }
    Column (
        modifier = modifier.fillMaxSize(),
    ) {
        WeekItem(
            modifier = modifier.weight(1f),
            week = week,
            schedule = schedule,
            selectDate = selectDate,
            onDateSelect = selectEvent,
        )
    }
}

@Composable
private fun WeekItem(
    week: List<Date>,
    schedule: Map<Date, List<Schedule>>,
    selectDate: Date?,
    onDateSelect: (Date) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxSize(),
    ) {
        week.forEach { date ->
            LifeNormalCalendarItem (
                modifier = modifier.weight(1f),
                date = date,
                scheduleList = schedule[date] ?: emptyList(),
                selected = selectDate == date,
                onDateClick = onDateSelect,
            )
        }
    }
}

@Preview(name = "SmallScheduleCalendar")
@Composable
private fun PreviewSmallScheduleCalendar() {
    val days = remember { Calendar.create(2025, 5).days[0] }
    val schedule = mapOf(
        days[0] to listOf(
            Schedule(
                date = days[0],
                content = "기차표 예매해야함",
                isHolyDay = true,
            ),
            Schedule(
                date = days[0],
                content = "기차표 예매해야함",
            ),
        ),
        days[1] to listOf(
            Schedule(
                date = days[1],
                content = "기차표 예매해야함",
                isCompleted = true,
            ),
            Schedule(
                date = days[1],
                content = "기차표 예매해야함",
            ),
            Schedule(
                date = days[1],
                content = "기차표 예매해야함",
            ),
        ),
    )
    var selectDate by remember {
        val today = days.find { it.isToday }
        mutableStateOf(today)
    }
    val selectEvent = { date: Date, index: Int ->
        selectDate = date
    }
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        LifeSmallScheduleCalendar(
            weekIndex = 1,
            selectDate = selectDate,
            week = days,
            schedule = schedule,
            onDateSelect = selectEvent,
        )
    }
}