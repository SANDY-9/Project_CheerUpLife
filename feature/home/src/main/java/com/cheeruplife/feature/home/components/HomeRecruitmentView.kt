
package com.cheeruplife.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeTextButton
import com.cheeruplife.core.designsystem.component.RecruitmentCard
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.LifeGray50
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R

@Composable
internal fun HomeRecruitmentView(
    onRecruitClick: () -> Unit,
    onRecruitItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifeGray50,
            )
            .defaultHorizontalMargin()
            .padding(
                top = Dimens.Margin30,
                bottom = Dimens.Margin18,
            ),
    ) {
        Title(
            onRecruitClick = onRecruitClick,
        )
        Margin(height = Dimens.Margin12)
        Content(
            onRecruitItemClick = onRecruitItemClick,
        )
    }
}

@Composable
private fun Title(
    onRecruitClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = modifier.align(Alignment.CenterStart),
            text = stringResource(R.string.home_recruit_title),
            style = Typography.titleLarge,
        )
        LifeTextButton(
            modifier = modifier.align(Alignment.CenterEnd),
            title = stringResource(R.string.home_content_more_title),
            onClick = onRecruitClick,
        )
    }
}

@Composable
private fun Content(
    onRecruitItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    repeat(4) {
        val itemClickEvent = remember {
            {  onRecruitItemClick("공고사이트")  }
        }
        RecruitmentCard(
            company = "녹십자",
            title = "[계약] 생산운영담당자(화순)",
            workType = "기간제/기타",
            companyType = "중견기업",
            startDate = "2025.04.28",
            endDate = "2025.05.11",
            dDay = 14,
            onItemClick = itemClickEvent,
        )
        Margin(height = Dimens.Margin12)
    }
}

@Preview(name = "HomeRecruitmentView")
@Composable
private fun PreviewHomeRecruitmentView() {
    HomeRecruitmentView(
        onRecruitClick = {},
        onRecruitItemClick = {},
    )
}