package com.cheeruplife.feature.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cheeruplife.feature.schedule.components.ScheduleToolbar

@Composable
internal fun ScheduleRoute(
    onNavigateBack: () -> Unit,
    viewModel: ScheduleViewModel = hiltViewModel(),
) {
    ScheduleScreen(
        onNavigateBack = onNavigateBack,
    )
}
@Composable
private fun ScheduleScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        ScheduleToolbar(
            onNavigateBack = onNavigateBack,
        )
    }
}

@Preview(name = "ScheduleScreen")
@Composable
private fun PreviewScheduleScreen() {
    ScheduleScreen(
        onNavigateBack = {},
    )
}