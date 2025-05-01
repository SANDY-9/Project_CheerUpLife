package com.cheeruplife.feature.recruit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.feature.recruit.components.RecruitHeader
import com.cheeruplife.feature.recruit.components.RecruitToolbar

@Composable
internal fun RecruitRoute(
    onNavigateBack: () -> Unit,
) {
    RecruitScreen(
        onNavigateBack = {},
    )
}

@Composable
private fun RecruitScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        RecruitToolbar(
            onNavigateBack = onNavigateBack,
        )
        LazyColumn(
            modifier = modifier.fillMaxSize(),
        ) {
            stickyHeader {
                RecruitHeader()
            }
        }
    }
}


@Preview(name = "RecruitScreen")
@Composable
private fun PreviewRecruitScreen() {
    RecruitScreen(
        onNavigateBack = {},
    )
}