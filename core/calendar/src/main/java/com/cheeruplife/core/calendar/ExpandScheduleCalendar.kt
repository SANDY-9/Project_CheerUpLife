package com.cheeruplife.core.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.model.Calendar
import com.cheeruplife.core.calendar.model.Week
import com.cheeruplife.core.designsystem.theme.LifeGray200
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.Schedule

@Composable
fun LifeExpandScheduleCalendar(
    selectDate: Date?,
    days: List<Week>,
    schedule: Map<Date, List<Schedule>>,
    onDateSelect: (Date, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier.fillMaxSize(),
    ) {
        days.forEachIndexed { weekIndex, days ->
            val selectEvent = remember {
                { date: Date -> onDateSelect(date, weekIndex) }
            }
            Column(
                modifier = modifier.weight(1f),
            ) {
                HorizontalDivider(color = LifeGray200)
                WeekItem(
                    week = days,
                    schedule = schedule,
                    selectDate = selectDate,
                    onDateSelect = selectEvent,
                )
            }
        }
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
        modifier = modifier.fillMaxWidth(),
    ) {
        week.forEach { date ->
            LifeExpandCalendarItem(
                modifier = modifier.weight(1f),
                date = date,
                scheduleList = schedule[date] ?: emptyList(),
                selected = selectDate == date,
                onDateClick = onDateSelect,
            )
        }
    }
}

@Preview(name = "ExpandScheduleCalendar")
@Composable
private fun PreviewExpandCalendar() {
    val days = remember { Calendar.create(2025, 5).days }
    val schedule = mapOf(
        days[0][0] to listOf(
            Schedule(
                date = days[0][0],
                content = "기차표 예매해야함",
            ),
            Schedule(
                date = days[0][0],
                content = "기차표 예매해야함",
            ),
        ),
        days[1][3] to listOf(
            Schedule(
                date = days[1][3],
                content = "기차표 예매해야함",
                isCompleted = true
            ),
            Schedule(
                date = days[1][3],
                content = "기차표 예매해야함",
            ),
            Schedule(
                date = days[1][3],
                content = "기차표 예매해야함",
            ),
        ),
    )
    var selectDate by remember {
        val today = days.flatten().find { it.isToday }
        mutableStateOf(today)
    }
    val selectEvent = { date: Date, week: Int ->
        selectDate = date
    }
    LifeExpandScheduleCalendar(
        selectDate = selectDate,
        days = days,
        schedule = schedule,
        onDateSelect = selectEvent,
    )
}