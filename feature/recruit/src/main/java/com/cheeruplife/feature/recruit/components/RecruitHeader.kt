package com.cheeruplife.feature.recruit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun RecruitHeader(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(
            color = Color.White,
        )
    ) {
        RecruitCompanyTypeFilter()
        RecruitSubHeader()
    }
}

@Preview(name = "RecruitHeader")
@Composable
private fun PreviewRecruitHeader() {
    RecruitHeader()
}