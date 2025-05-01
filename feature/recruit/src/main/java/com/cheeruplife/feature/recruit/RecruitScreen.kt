package com.cheeruplife.feature.recruit

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun RecruitRoute() {
    RecruitScreen()
}

@Composable
private fun RecruitScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "RecruitScreen")
    }
}

@Preview(name = "RecruitScreen")
@Composable
private fun PreviewRecruitScreen() {
    RecruitScreen()
}