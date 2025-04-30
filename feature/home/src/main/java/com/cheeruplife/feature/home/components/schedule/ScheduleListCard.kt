package com.cheeruplife.feature.home.components.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
internal fun ScheduleListCard(
    onScheduleItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LifeGray100,
                shape = RoundSquare.Large,
            )
            .defaultHorizontalMargin()
            .padding(vertical = Dimens.Margin12)
            .clip(RoundSquare.Large)
            .clickable(onClick = onScheduleItemClick),
        verticalArrangement = Arrangement.spacedBy(Dimens.Margin8)
    ) {
        repeat(2) { index ->
            /*when {
                completed -> NotCompleteItem(
                    content = "매일 7시 30분 기상 도전",
                )
                else -> NotCompleteItem(
                    content = "매일 7시 30분 기상 도전",
                )
            }*/
            if(index == 0) {
                CompleteItem(
                    content = "에너지 빅데이터 교육 마감일",
                )
            }
            else {
                NotCompleteItem(
                    content = "매일 7시 30분 기상 도전",
                )
            }
        }
    }
}

@Composable
private fun CompleteItem(
    content: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = modifier.size(Dimens.Size16),
            imageVector = Icons.Rounded.CheckCircle,
            contentDescription = null,
            tint = LifeRed,
        )
        Margin(width = Dimens.Margin4)
        Text(
            text = content,
            style = Typography.bodyLarge,
            color = LifeRed,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun NotCompleteItem(
    content: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = content,
        style = Typography.bodyLarge,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Preview(name = "ScheduleList")
@Composable
private fun PreviewScheduleList() {
    ScheduleListCard(onScheduleItemClick = {})
}