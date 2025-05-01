package com.cheeruplife.feature.recruit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeCheckButtonControlView
import com.cheeruplife.core.designsystem.component.LifeNavigateTitleToolbar
import com.cheeruplife.feature.recruit.R

@Composable
internal fun RecruitToolbar(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LifeNavigateTitleToolbar(
            title = stringResource(R.string.recruit_title),
            onNavigate = onNavigateBack,
        )
    }
}

@Preview(name = "RecruitToolbar")
@Composable
private fun PreviewRecruitToolbar() {
    RecruitToolbar(
        onNavigateBack = {},
    )
}