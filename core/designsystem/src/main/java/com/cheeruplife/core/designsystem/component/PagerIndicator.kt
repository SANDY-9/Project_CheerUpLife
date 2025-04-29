package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.theme.LifeBlack
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifePagerIndicator(
    currentPage: Int,
    totalPage: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.background(
            color = LifeBlack.copy(
                alpha = 0.5f
            ),
            shape = RoundSquare.Large
        ).padding(
            horizontal = Dimens.Margin12,
            vertical = Dimens.Margin4,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$currentPage",
            style = Typography.bodyMedium.copy(
                fontWeight = FontWeight.ExtraBold,
            ),
            color = Color.White,
        )
        Margin(width = Dimens.Margin3)
        Text(
            text = "/",
            style = Typography.bodyMedium,
            color = LifeGray400,
        )
        Margin(width = Dimens.Margin2)
        Text(
            text = "$totalPage",
            style = Typography.bodyMedium,
            color = LifeGray400,
        )
    }
}

@Preview(name = "PagerIndicator")
@Composable
private fun PreviewPagerIndicator() {
    LifePagerIndicator(
        currentPage = 3,
        totalPage = 5,
    )
}