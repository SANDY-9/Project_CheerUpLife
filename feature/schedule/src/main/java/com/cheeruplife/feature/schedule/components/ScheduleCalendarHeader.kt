package com.cheeruplife.feature.schedule.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.LifeCalendarHeader
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
internal fun ScheduleCalendarHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.Margin4),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "5월",
            style = Typography.titleMedium,
        )
        Margin(height = Dimens.Margin8)
        LifeCalendarHeader()
    }
}

@Preview(name = "ScheduleCalendarHeader")
@Composable
private fun PreviewScheduleHeader() {
    ScheduleCalendarHeader()
}