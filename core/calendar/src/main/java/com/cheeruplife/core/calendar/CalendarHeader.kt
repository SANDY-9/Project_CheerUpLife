package com.cheeruplife.core.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.utils.color
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.model.enums.DayOfWeek

private val dayOfWeekList = DayOfWeek.entries

@Composable
internal fun LifeCalendarHeader(
    modifier: Modifier = Modifier,
    dayOfWeeks: List<DayOfWeek> = dayOfWeekList,
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        dayOfWeeks.forEach { dayOfWeek ->
            val color = remember { dayOfWeek.color() }
            DayOfWeekTitle(
                modifier = modifier.weight(1f),
                name = dayOfWeek.desc,
                color = color,
            )
        }
    }
}

@Composable
private fun DayOfWeekTitle(
    name: String,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.Size2),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = name,
            style = Typography.labelMedium,
            color = color,
            fontWeight = FontWeight.Bold,
        )
    }
}


@Preview(name = "CalendarHeader")
@Composable
private fun PreviewCalendarHeader() {
    LifeCalendarHeader()
}