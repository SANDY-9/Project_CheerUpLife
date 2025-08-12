package com.cheeruplife.feature.schedule.components.schedulecard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.component.LifeTouchDetectContainer
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.extension.isOutTouched
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.resources.icons.MyIconPack
import com.cheeruplife.core.resources.icons.myiconpack.EditCalendar

@Composable
internal fun NotCompleteScheduleItem(
    content: String,
    onCompleteClick: () -> Unit,
    onEditClick: () -> Unit,
    onRemoveClick: () -> Unit,
    touchOffset: Offset?,
    modifier: Modifier = Modifier,
) {
    var menuButtonRect by remember { mutableStateOf<Rect?>(null) }
    val outTouched = touchOffset?.isOutTouched(menuButtonRect)
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
        Box(
            modifier = modifier.onGloballyPositioned {
                menuButtonRect = it.boundsInWindow()
            }
        ) {
            ScheduleItemMenuButton(
                onCompleteClick = onCompleteClick,
                onEditClick = onEditClick,
                onRemoveClick = onRemoveClick,
                outTouch = outTouched,
                color = LifeGray,
            )
        }
    }
}


@Preview(name = "NotCompleteScheduleItem")
@Composable
private fun PreviewNotCompleteScheduleItem() {
    LifeTouchDetectContainer { touchOffset ->
        NotCompleteScheduleItem(
            content = "기차표 예매해야함",
            onEditClick = {},
            onRemoveClick = {},
            onCompleteClick = {},
            touchOffset = touchOffset,
        )
    }
}