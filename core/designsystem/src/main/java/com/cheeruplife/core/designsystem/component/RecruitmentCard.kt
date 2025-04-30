package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.core.designsystem.theme.LifeGray200
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeGray500
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.LifeGray900
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun RecruitmentCard(
    company: String,
    title: String,
    workType: String,
    companyType: String,
    startDate: String,
    endDate: String,
    dDay: Int,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundSquare.Large,
                ambientColor = LifeGray500,
                spotColor = LifeGray500,
            ),
        onClick = onItemClick,
        shape = RoundSquare.Large,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .defaultHorizontalMargin()
                .padding(vertical = Dimens.Margin12),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = company,
                    style = Typography.titleSmall,
                    color = LifeGray900,
                )
                Margin(modifier = modifier.weight(1f))
                Text(
                    text = "D-${dDay}",
                    style = Typography.bodyMedium,
                    color = LifeRed,
                )
            }
            Text(
                modifier = modifier.fillMaxWidth(),
                text = title,
                style = Typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Margin(height = Dimens.Margin4)
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = workType,
                    style = Typography.labelMedium,
                )
                Margin(width = Dimens.Margin8)
                Text(
                    text = "|",
                    style = Typography.labelMedium,
                    color = LifeGray400,
                )
                Margin(width = Dimens.Margin8)
                Text(
                    text = companyType,
                    style = Typography.labelMedium,
                    color = LifeGray700,
                )
            }
            Text(
                modifier = modifier.align(Alignment.End),
                text = "${startDate} - ${endDate}",
                style = Typography.bodySmall,
                color = LifeGray900,
            )
        }
    }
}

@Preview(name = "RecruitmentCard")
@Composable
private fun PreviewRecruitmentCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = LifeGray100)
            .padding(Dimens.Size16)
    ) {
        RecruitmentCard(
            company = "녹십자",
            title = "[계약] 생산운영담당자(화순)",
            workType = "기간제/기타",
            companyType = "중견기업",
            startDate = "2025.04.28",
            endDate = "2025.05.11",
            dDay = 14,
            onItemClick = {},
        )
    }
}