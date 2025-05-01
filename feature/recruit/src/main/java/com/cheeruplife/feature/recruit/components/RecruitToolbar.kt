package com.cheeruplife.feature.recruit.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.component.LifeNavigateTitleToolbar
import com.cheeruplife.feature.recruit.R

@Composable
internal fun RecruitToolbar(
    modifier: Modifier = Modifier,
) {
    LifeNavigateTitleToolbar(
        title = stringResource(R.string.recruit_title),
        onNavigate = {}
    )
}

@Preview(name = "RecruitToolbar")
@Composable
private fun PreviewRecruitToolbar() {
    RecruitToolbar()
}