package com.cheeruplife.core.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.utils.color
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.model.Date
import com.cheeruplife.core.model.enums.DayOfWeek

@Composable
internal fun DateHeader(
    date: Date,
    modifier: Modifier = Modifier,
) {
    val backColor = remember {
        if(date.isToday) date.dayOfWeek.color() else Color.Transparent
    }
    val fontColor = remember {
        if(date.isToday) Color.White else date.dayOfWeek.color()
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backColor,
                shape = RoundSquare.Small,
            )
            .padding(vertical = Dimens.Size2),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "${date.day}",
            style = Typography.labelMedium,
            color = fontColor,
        )
    }
}
@Preview(name = "DateHeader")
@Composable
private fun PreviewDateHeader() {
    val date = Date(
        day = 21,
        year = 2025,
        month = 4,
        dayOfWeek = DayOfWeek.WEDNESDAY,
        isToday = true,
    )
    DateHeader(date)
}