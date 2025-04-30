package com.cheeruplife.feature.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeSelectableWeekdayBox
import com.cheeruplife.core.designsystem.component.LifeTextButton
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R
import com.cheeruplife.feature.home.components.schedule.DateBox
import com.cheeruplife.feature.home.components.schedule.EmptyScheduleCard
import com.cheeruplife.feature.home.components.schedule.ScheduleListCard

@Composable
internal fun HomeScheduleView(
    onScheduleClick: () -> Unit,
    onDayOfWeekSelect: (Int) -> Unit,
    onScheduleItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // -- 테스트 전용
    var emptySchedule by remember {
        mutableStateOf(false)
    }
    val selectEvent = remember {
        { dayOfWeek: Int ->
            emptySchedule = dayOfWeek % 2 != 0
            onDayOfWeekSelect(dayOfWeek)

        }
    } // --테스트 전용

    Column(
        modifier = modifier.fillMaxWidth().padding(
            top = Dimens.Margin4,
        )
    ) {
        Title(onScheduleClick = onScheduleClick)
        Margin(height = Dimens.Margin12)
        LifeSelectableWeekdayBox(
            onSelect = selectEvent, // --테스트 전용
        )
        Margin(height = Dimens.Margin4)
        Content(
            date = "4월 30일",
            isEmptySchedule = emptySchedule,
            onScheduleItemClick = onScheduleItemClick,
        )
    }
}

@Composable
private fun Title(
    onScheduleClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin()
    ) {
        Text(
            modifier = modifier.align(Alignment.CenterStart),
            text = stringResource(R.string.home_schedule_title),
            style = Typography.titleLarge,
        )
        LifeTextButton(
            modifier = modifier.align(Alignment.CenterEnd),
            title = stringResource(R.string.home_content_more_title),
            onClick = onScheduleClick,
        )
    }
}

@Composable
private fun Content(
    date: String,
    isEmptySchedule: Boolean,
    onScheduleItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin(),
    ) {
        DateBox(date = date)
        Margin(width = Dimens.Margin12)
        when {
            isEmptySchedule -> EmptyScheduleCard(
                onScheduleItemClick = onScheduleItemClick,
            )
            else -> ScheduleListCard(
                onScheduleItemClick = onScheduleItemClick,
            )
        }
    }
}

@Preview(name = "HomeScheduleView")
@Composable
private fun PreviewHomeScheduleView() {
    HomeScheduleView(
        onScheduleClick = {},
        onDayOfWeekSelect = {},
        onScheduleItemClick = {},
    )
}