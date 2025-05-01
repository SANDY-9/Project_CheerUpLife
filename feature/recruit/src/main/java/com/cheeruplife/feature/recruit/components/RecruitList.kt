package com.cheeruplife.feature.recruit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.component.RecruitmentList
import com.cheeruplife.core.designsystem.theme.LifeGray50

@Composable
internal fun RecruitList(
    onRecruitItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth().background(
            color = LifeGray50,
        ).padding(
            top = Dimens.Margin8,
            bottom = Dimens.Margin16,
        )
    ) {
        repeat(10) {
            val itemClickEvent = remember {
                {  onRecruitItemClick("공고사이트")  }
            }
            RecruitmentList(
                company = "녹십자",
                title = "[계약] 생산운영담당자(화순)",
                workType = "기간제/기타",
                companyType = "중견기업",
                startDate = "2025.04.28",
                endDate = "2025.05.11",
                dDay = 14,
                photoUrl = "https://www.work.go.kr/framework/filedownload/getImage.do?filePathName=tqyczLUvysXSEcOVhPgDCv%2FeG2%2FbAG80R6RphJNi05vB7l0VrxvB28SFg%2B23lKU9FFsj1HiYIQ4BTknQX5YH19Y0itEH13n0HGyGJc%2FTw8k%3D",
                onItemClick = itemClickEvent,
            )
        }
    }
}

@Preview(name = "RecruitList")
@Composable
private fun PreviewRecruitList() {
    RecruitList(
        onRecruitItemClick = {},
    )
}