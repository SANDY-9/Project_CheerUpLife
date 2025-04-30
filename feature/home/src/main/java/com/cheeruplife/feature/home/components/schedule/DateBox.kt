package com.cheeruplife.feature.home.components.schedule

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
internal fun DateBox(
    date: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.border(
            width = Dimens.Size1,
            color = LifeGray400,
            shape = CircleShape,
        ).padding(
            horizontal = Dimens.Margin16,
            vertical = Dimens.Margin4,
        ),
        text = date,
        style = Typography.bodyMedium,
        color = LifeRed,
    )
}

@Preview(name = "DateBox")
@Composable
private fun PreviewDateBox() {
    DateBox(date = "4월 30일")
}