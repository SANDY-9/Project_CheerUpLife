package com.cheeruplife.feature.schedule.components.schedulecard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.LifePureRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
internal fun HolidayScheduleItem(
    content: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Rounded.Star,
            tint = LifePureRed,
            contentDescription = null,
        )
        Text(
            modifier = modifier
                .weight(1f)
                .padding(horizontal = Dimens.Margin8),
            text = content,
            style = Typography.bodyMedium,
            color = LifePureRed,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(name = "HolidayScheduleItem")
@Composable
private fun PreviewHolidayScheduleItem() {
    HolidayScheduleItem(
        content = "기차표 예매해야함",
    )
}