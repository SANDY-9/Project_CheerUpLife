package com.cheeruplife.feature.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun ScheduleRoute(
    viewModel: ScheduleViewModel = hiltViewModel(),
) {
    ScheduleScreen()
}
@Composable
private fun ScheduleScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "ScheduleScreen")
    }
}

@Preview(name = "ScheduleScreen")
@Composable
private fun PreviewScheduleScreen() {
    ScheduleScreen()
}