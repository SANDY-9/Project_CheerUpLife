package com.cheeruplife.feature.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheeruplife.core.model.Schedule
import com.cheeruplife.feature.schedule.components.ScheduleCalendarHeader
import com.cheeruplife.feature.schedule.components.SchedulePager
import com.cheeruplife.feature.schedule.components.ScheduleToolbar

@Composable
internal fun ScheduleRoute(
    onNavigateBack: () -> Unit,
    viewModel: ScheduleViewModel = hiltViewModel(),
) {
    ScheduleScreen(
        onNavigateBack = onNavigateBack,
        onPositionChane = { _:Int, _:Int -> viewModel },
        onCompleteChange = {_:Schedule, _:Boolean -> viewModel },
    )
}
@Composable
private fun ScheduleScreen(
    onNavigateBack: () -> Unit,
    onPositionChane: (Int, Int) -> Unit,
    onCompleteChange: (Schedule, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(),
    ) {
        ScheduleToolbar(
            onNavigateBack = onNavigateBack,
        )
        ScheduleCalendarHeader()
        SchedulePager(
            onPositionChane = onPositionChane,
            onCompleteChange = onCompleteChange,
        )
    }
}

@Preview(name = "ScheduleScreen")
@Composable
private fun PreviewScheduleScreen() {
    ScheduleScreen(
        onNavigateBack = {},
        onPositionChane = { _:Int, _:Int ->  },
        onCompleteChange = {_:Schedule, _:Boolean -> },
    )
}