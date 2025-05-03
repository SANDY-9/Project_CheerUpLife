package com.cheeruplife.core.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.extension.noRippleClickable
import com.cheeruplife.core.designsystem.theme.LifeGray200
import com.cheeruplife.core.designsystem.theme.LifePastelRed
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.Schedule
import com.cheeruplife.core.model.enums.DayOfWeek

@Composable
internal fun LifeNormalCalendarItem(
    date: Date,
    scheduleList: List<Schedule>,
    selected: Boolean,
    onDateClick: (Date) -> Unit,
    modifier: Modifier = Modifier,
) {
    val clickEvent = remember {
        { onDateClick(date) }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .then(
                if (selected) {
                    Modifier
                        .border(
                            width = Dimens.Size1,
                            color = LifeRed,
                            shape = RoundSquare.Small,
                        )
                        .clip(
                            RoundSquare.Small,
                        )
                } else {
                    Modifier
                }
            )
            .padding(
                horizontal = Dimens.Margin2,
                vertical = Dimens.Margin2,
            )
            .noRippleClickable(onClick = clickEvent),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DateHeader(date = date)
        Margin(height = Dimens.Margin4)
        scheduleList.forEach { schedule ->
            when {
                schedule.isHolyDay -> HolidayItem()
                schedule.isCompleted -> CompleteScheduleItem()
                else -> ScheduleItem()
            }
            Margin(height = Dimens.Margin2)
        }
    }
}

@Composable
private fun HolidayItem(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifePastelRed,
                shape = RoundSquare.Small,
            )
            .height(Dimens.Size8),
    )
}

@Composable
private fun ScheduleItem(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifeGray200,
                shape = RoundSquare.Small,
            )
            .height(Dimens.Size8),
    )
}

@Composable
private fun CompleteScheduleItem(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifeRed,
                shape = RoundSquare.Small,
            )
            .height(Dimens.Size8),
    )
}

@Preview(name = "NormalCalendarItem")
@Composable
private fun PreviewNormalCalendarItem() {
    var selected by remember { mutableStateOf(false) }
    val date = Date(
        day = 21,
        year = 2025,
        month = 4,
        dayOfWeek = DayOfWeek.WEDNESDAY,
        isToday = true,
    )
    Box(
        modifier = Modifier.size(
            width = 70.dp,
            height = 80.dp,
        )
    ) {
        LifeNormalCalendarItem(
            date = date,
            selected = selected,
            scheduleList = listOf(
                Schedule(
                    date = date,
                    content = "기차표 예매해야함",
                    isHolyDay = true,
                ),
                Schedule(
                    date = date,
                    content = "기차표 예매해야함",
                    isCompleted = true
                ),
                Schedule(
                    date = date,
                    content = "기차표 예매해야함",
                )
            ),
            onDateClick = { selected = !selected },
        )
    }
}