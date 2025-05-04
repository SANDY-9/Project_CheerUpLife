package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.extension.noRippleClickable
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.core.designsystem.theme.LifePureRed
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.resources.icons.MyIconPack
import com.cheeruplife.core.resources.icons.myiconpack.EditCalendar

@Composable
fun ScheduleCard(
    content: String,
    isComplete: Boolean,
    isHoliday: Boolean,
    onCompleteChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val completeChangeEvent = {
        onCompleteChange(!isComplete)
    }
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Margin(height = Dimens.Margin8)
        when {
            isComplete -> CompleteScheduleItem(
                content = content,
                onClick = completeChangeEvent,
            )
            isHoliday -> HolidayScheduleItem(
                content = content,
            )
            else -> NotCompleteScheduleItem(
                content = content,
                onClick = completeChangeEvent,
            )
        }
        Margin(height = Dimens.Margin8)
        HorizontalDivider(color = LifeGray100)
    }
}

@Composable
private fun HolidayScheduleItem(
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

@Composable
private fun CompleteScheduleItem(
    content: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = MyIconPack.EditCalendar,
            tint = LifeRed,
            contentDescription = null,
        )
        Text(
            modifier = modifier
                .weight(1f)
                .padding(horizontal = Dimens.Margin8),
            text = content,
            style = Typography.bodyMedium,
            color = LifeRed,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Icon(
            modifier = modifier.noRippleClickable(onClick = onClick),
            imageVector = Icons.Rounded.CheckCircle,
            contentDescription = null,
            tint = LifeRed,
        )
    }
}

@Composable
private fun NotCompleteScheduleItem(
    content: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = MyIconPack.EditCalendar,
            tint = LifeGray,
            contentDescription = null,
        )
        Text(
            modifier = modifier
                .weight(1f)
                .padding(horizontal = Dimens.Margin8),
            text = content,
            style = Typography.bodyMedium,
            color = LifeGray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Icon(
            modifier = modifier.noRippleClickable(onClick = onClick),
            imageVector = Icons.Rounded.CheckCircle,
            contentDescription = null,
            tint = LifeGray,
        )
    }
}

@Preview(name = "ScheduleCard")
@Composable
private fun PreviewScheduleCard() {
    var isComplete1 by remember { mutableStateOf(true) }
    var isComplete2 by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.Margin8)
    ) {
        ScheduleCard(
            isComplete = isComplete1,
            isHoliday = false,
            content = "기차표 예매해야함",
            onCompleteChange = { isComplete1 = it },
        )
        ScheduleCard(
            isComplete = isComplete2,
            isHoliday = true,
            content = "어린이날",
            onCompleteChange = { isComplete2 = it },
        )
        ScheduleCard(
            isComplete = isComplete2,
            isHoliday = false,
            content = "기차표 예매해야함",
            onCompleteChange = { isComplete2 = it },
        )
    }
}