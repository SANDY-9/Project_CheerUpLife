package com.cheeruplife.core.calendar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.model.Calendar
import com.cheeruplife.core.calendar.model.Calendar.Companion.findWeekIndex
import com.cheeruplife.core.calendar.model.CalendarType
import com.cheeruplife.core.calendar.model.ScrollState
import com.cheeruplife.core.calendar.model.Week
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.Schedule
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LifeFlexibleCalendarView(
    selectDate: Date?,
    selectDateWeekIndex: Int,
    days: List<Week>,
    schedule: Map<Date, List<Schedule>>,
    onDateSelect: (Date, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    var type by remember { mutableStateOf(CalendarType.EXPANDED_CALENDAR) }
    var targetFraction by remember { mutableFloatStateOf(1f) }
    var scrollState by remember { mutableStateOf(ScrollState.NONE) }

    LaunchedEffect(targetFraction) {
        snapshotFlow { targetFraction }.collectLatest { fraction ->
            type = when {
                fraction > 0.5f -> CalendarType.EXPANDED_CALENDAR
                fraction > 0.1f -> CalendarType.NORMAL_CALENDAR
                else -> CalendarType.SMALL_CALENDAR
            }
        }
    }

    val dragEvent = remember {
        { _:PointerInputChange, dragAmount: Float ->
            if(dragAmount > 0 && targetFraction < 1f) {
                targetFraction += 0.01f
                scrollState = ScrollState.DOWN_SCROLL
            }
            if(dragAmount < 0 && targetFraction > 0.1f) {
                targetFraction -= 0.01f
                scrollState = ScrollState.UP_SCROLL
            }
        }
    }
    
    val dragEndEvent = remember {
        {
            targetFraction = when {
                targetFraction > 0.5f -> if(scrollState == ScrollState.UP_SCROLL) 0.5f else 1f
                targetFraction > 0.1f -> if(scrollState == ScrollState.UP_SCROLL) 0.1f else 0.5f
                else -> 0.1f
            }
            scrollState = ScrollState.NONE
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LifeCalendarHeader()
        Box(
            modifier = modifier
                .animateContentSize()
                .fillMaxHeight(targetFraction)
                .pointerInput(Unit) {
                    detectVerticalDragGestures(
                        onVerticalDrag = dragEvent,
                        onDragEnd = dragEndEvent,
                    )
                }
        ) {
            when(type) {
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
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LifeFlexibleCalendarView(
            selectDate = selectDate,
            selectDateWeekIndex = selectDateWeekIndex,
            days = days,
            schedule = schedule,
            onDateSelect = selectEvent,
        )
    }
}