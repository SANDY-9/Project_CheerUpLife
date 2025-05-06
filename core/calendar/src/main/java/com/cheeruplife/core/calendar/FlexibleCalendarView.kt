package com.cheeruplife.core.calendar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.components.LifeExpandScheduleCalendar
import com.cheeruplife.core.calendar.components.LifeNormalScheduleCalendar
import com.cheeruplife.core.calendar.components.LifeSmallScheduleCalendar
import com.cheeruplife.core.calendar.model.Calendar
import com.cheeruplife.core.calendar.model.Calendar.Companion.findWeekIndex
import com.cheeruplife.core.calendar.model.CalendarType
import com.cheeruplife.core.calendar.model.Week
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.Schedule

@Composable
fun LifeFlexibleCalendarView(
    calendarState: FlexibleCalendarState,
    selectDate: Date?,
    selectDateWeekIndex: Int,
    days: List<Week>,
    schedule: Map<Date, List<Schedule>>,
    onDateSelect: (Date, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .animateContentSize()
            .fillMaxHeight(calendarState.fraction)
            .pointerInput(Unit) {
                detectVerticalDragGestures(
                    onVerticalDrag = calendarState::onVerticalDrag,
                    onDragEnd = calendarState::onDragEnd,
                )
            }
    ) {
        when(calendarState.type) {
            CalendarType.EXPANDED_CALENDAR -> LifeExpandScheduleCalendar(
                selectDate = selectDate,
                days = days,
                schedule = schedule,
                onDateSelect = onDateSelect,
            )
            CalendarType.NORMAL_CALENDAR -> LifeNormalScheduleCalendar(
                selectDate = selectDate,
                days = days,
                schedule = schedule,
                onDateSelect = onDateSelect,
            )
            CalendarType.SMALL_CALENDAR -> LifeSmallScheduleCalendar(
                weekIndex = selectDateWeekIndex,
                selectDate = selectDate,
                week = days[selectDateWeekIndex],
                schedule = schedule,
                onDateSelect = onDateSelect,
            )
        }
    }
}

@Preview(name = "FlexibleCalendarView")
@Composable
private fun PreviewFlexibleCalendarView() {
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
    var selectDateWeekIndex by remember {
        val weekIndex = selectDate?.let {
            days.findWeekIndex(it)
        } ?: 0
        mutableIntStateOf(weekIndex)
    }
    val selectEvent = { date: Date, index: Int ->
        selectDate = date
        selectDateWeekIndex = index
    }
    val calendarState = rememberFlexibleCalendarState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LifeFlexibleCalendarView(
            calendarState = calendarState,
            selectDate = selectDate,
            selectDateWeekIndex = selectDateWeekIndex,
            days = days,
            schedule = schedule,
            onDateSelect = selectEvent,
        )
    }
}