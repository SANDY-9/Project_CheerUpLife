package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.extension.defaultVerticalMargin
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.LifeGray900
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun RecruitmentList(
    company: String,
    title: String,
    workType: String,
    companyType: String,
    startDate: String,
    endDate: String,
    dDay: Int,
    photoUrl: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.Margin4)
            .background(color = Color.White)
            .border(
                width = Dimens.Size1,
                color = LifeGray100,
            )
            .clickable(onClick = onItemClick)
            .defaultHorizontalMargin(),
    ) {
        Margin(height = Dimens.Margin12)
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = company,
                style = Typography.titleSmall,
                color = LifeGray900,
            )
            Margin(modifier = modifier.weight(1f))
            LifeAsyncImage(
                modifier = modifier.size(
                    width = Dimens.Size72,
                    height = Dimens.Size24,
                ),
                url = photoUrl,
            )
        }
        Text(
            modifier = modifier.fillMaxWidth(),
            text = title,
            style = Typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Row {
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
        Margin(height = Dimens.Margin8)
        Row {
            Text(
                modifier = modifier
                    .background(
                        color = LifeGray100,
                    )
                    .padding(horizontal = Dimens.Margin4),
                text = "D-${dDay}",
                style = Typography.labelLarge,
                color = LifeRed,
            )
            Margin(modifier = modifier.weight(1f))
            Text(
                text = "$startDate - $endDate",
                style = Typography.bodySmall,
                color = LifeGray900,
            )
        }
        Margin(height = Dimens.Margin12)
    }
}

@Preview(name = "RecruitmentList")
@Composable
private fun PreviewRecruitmentList() {
    Column (
        modifier = Modifier.defaultVerticalMargin(),
    ) {
        repeat(3) {
            RecruitmentList(
                company = "녹십자",
                title = "[계약] 생산운영담당자(화순)",
                workType = "기간제/기타",
                companyType = "중견기업",
                startDate = "2025.04.28",
                endDate = "2025.05.11",
                dDay = 14,
                photoUrl = "https://www.work.go.kr/framework/filedownload/getImage.do?filePathName=tqyczLUvysXSEcOVhPgDCv%2FeG2%2FbAG80R6RphJNi05vB7l0VrxvB28SFg%2B23lKU9FFsj1HiYIQ4BTknQX5YH19Y0itEH13n0HGyGJc%2FTw8k%3D",
                onItemClick = {},
            )
        }
    }
}