package com.cheeruplife.core.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.extension.noRippleClickable
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray200
import com.cheeruplife.core.designsystem.theme.LifePastelRed
import com.cheeruplife.core.designsystem.theme.LifePureRed
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.Schedule
import com.cheeruplife.core.model.enums.DayOfWeek

@Composable
internal fun LifeExpandCalendarItem(
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
                schedule.isHolyDay -> HolidayItem(
                    holiday = schedule.content,
                )
                schedule.isCompleted -> CompleteScheduleItem(
                    content = schedule.content,
                )
                else -> ScheduleItem(
                    content = schedule.content,
                )
            }
            Margin(height = Dimens.Margin2)
        }
    }
}

@Composable
private fun HolidayItem(
    holiday: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifePastelRed,
                shape = RoundSquare.Small,
            )
            .padding(
                Dimens.Size1,
            ),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = holiday,
            style = Typography.labelSmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = LifePureRed,
        )
    }
}

@Composable
private fun ScheduleItem(
    content: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifeGray200,
                shape = RoundSquare.Small,
            )
            .padding(
                Dimens.Size1,
            ),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = content,
            style = Typography.labelSmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = LifeGray,
        )
    }
}

@Composable
private fun CompleteScheduleItem(
    content: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifeRed,
                shape = RoundSquare.Small,
            )
            .padding(
                Dimens.Size1,
            ),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = content,
            style = Typography.labelSmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
        )
    }
}


@Preview(name = "CalendarItem")
@Composable
private fun PreviewCalendarItem() {
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
            height = 120.dp,
        )
    ) {
        LifeExpandCalendarItem(
            date = date,
            selected = selected,
            scheduleList = listOf(
                Schedule(
                    date = date,
                    content = "기차표 예매해야함",
                    isCompleted = true
                ),
                Schedule(
                    date = date,
                    content = "기차표 예매해야함",
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