package com.cheeruplife.feature.schedule.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.calendar.model.Calendar
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.ScheduleCard
import com.cheeruplife.core.designsystem.dragdrop.LifeDragAndDropListView
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.LifeBlack
import com.cheeruplife.core.designsystem.theme.LifeGray200
import com.cheeruplife.core.designsystem.theme.LifeGray600
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.model.Schedule
import com.cheeruplife.core.model.enums.ScheduleType
import com.cheeruplife.core.resources.icons.MyIconPack
import com.cheeruplife.core.resources.icons.myiconpack.EditCalendar
import com.cheeruplife.feature.schedule.R

@Composable
internal fun ScheduleList(
    schedule: List<Schedule>,
    onPositionChane: (Int, Int) -> Unit,
    onCompleteChange: (Schedule, Boolean) -> Unit,
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalDivider(color = LifeGray200,)
        Margin(height = Dimens.Margin16)
        ScheduleTitle()
        Margin(height = Dimens.Margin8)
        if(schedule.isEmpty()) {
            EmptySchedule()
        }
        else {
            LifeDragAndDropListView(
                item = schedule,
                onPositionChange = onPositionChane,
            ) { modifier, item ->
                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    ScheduleCard(
                        content = item.content,
                        isComplete = item.type == ScheduleType.COMPLETE,
                        isHoliday = item.type == ScheduleType.HOLIDAY,
                        onCompleteChange = { complete ->
                            onCompleteChange(item, complete)
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun ScheduleTitle(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.schedule_list_title, 2025, 5, 5),
            style = Typography.titleSmall,
            color = LifeBlack,
        )
    }
}

@Composable
private fun EmptySchedule(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin()
            .padding(vertical = Dimens.Margin8)
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = MyIconPack.EditCalendar,
            tint = LifeGray600,
            contentDescription = null,
        )
        Text(
            modifier = modifier
                .weight(1f)
                .padding(horizontal = Dimens.Margin8),
            text = stringResource(R.string.schedule_empty_content),
            style = Typography.bodyMedium,
            color = LifeGray600,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(name = "ScheduleList")
@Composable
private fun PreviewScheduleList() {
    val days = remember { Calendar.create(2025, 5).days }
    val schedule = listOf(
        Schedule(
            date = days[0][0],
            content = "기차표 예매해야함",
        ),
        Schedule(
            date = days[0][0],
            content = "기차표 예매해야함",
        ),
    )
    ScheduleList(
        schedule = schedule,
        onPositionChane = { _:Int, _:Int -> },
        onCompleteChange = { _:Schedule, _:Boolean -> },
    )
}