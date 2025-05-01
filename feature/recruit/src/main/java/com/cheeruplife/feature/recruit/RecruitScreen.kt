package com.cheeruplife.feature.recruit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.feature.recruit.components.RecruitToolbar

@Composable
internal fun RecruitRoute() {
    RecruitScreen()
}

@Composable
private fun RecruitScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        stickyHeader {
            RecruitToolbar()
        }
    }
}

@Preview(name = "RecruitScreen")
@Composable
private fun PreviewRecruitScreen() {
    RecruitScreen()
}