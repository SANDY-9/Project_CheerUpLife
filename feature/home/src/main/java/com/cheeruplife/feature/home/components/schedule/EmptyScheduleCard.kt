package com.cheeruplife.feature.home.components.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R

@Composable
internal fun EmptyScheduleCard(
    onScheduleItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
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
    ) {
        Text(
            text = stringResource(R.string.home_schedule_empty),
            style = Typography.bodyLarge,
            color = LifeGray,
        )
    }
}

@Preview(name = "EmptySchedule")
@Composable
private fun PreviewEmptySchedule() {
    EmptyScheduleCard(onScheduleItemClick = {})
}