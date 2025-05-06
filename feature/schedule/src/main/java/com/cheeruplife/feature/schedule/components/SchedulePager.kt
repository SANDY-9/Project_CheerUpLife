package com.cheeruplife.feature.schedule.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.LifeFlexibleCalendarView
import com.cheeruplife.core.calendar.model.Calendar
import com.cheeruplife.core.calendar.model.Calendar.Companion.findWeekIndex
import com.cheeruplife.core.calendar.rememberFlexibleCalendarState
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.Schedule

@Composable
internal fun SchedulePager(
    onPositionChane: (Int, Int) -> Unit,
    onCompleteChange: (Schedule, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
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
    var selectedSchedule by remember {
        mutableStateOf(schedule[selectDate] ?: emptyList())
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
    val pagerState = rememberPagerState(
        initialPage = Int.MAX_VALUE / 2,
        pageCount = { Int.MAX_VALUE },
    )
    val calendarState = rememberFlexibleCalendarState()
    HorizontalPager(
        modifier = modifier.fillMaxSize(),
        state = pagerState,
    ) {
        Column {
            LifeFlexibleCalendarView(
                modifier = modifier.padding(horizontal = Dimens.Margin4),
                calendarState = calendarState,
                selectDate = selectDate,
                selectDateWeekIndex = selectDateWeekIndex,
                days = days,
                schedule = schedule,
                onDateSelect = selectEvent,
            )
            ScheduleList(
                schedule = selectedSchedule,
                onPositionChane = onPositionChane,
                onCompleteChange = onCompleteChange,
            )
        }
    }
}

@Preview(name = "SchedulePager")
@Composable
private fun PreviewSchedulePager() {
    SchedulePager(
        onPositionChane = {
            _:Int, _:Int ->
        },
        onCompleteChange = {
            _:Schedule, _:Boolean ->
        },
    )
}