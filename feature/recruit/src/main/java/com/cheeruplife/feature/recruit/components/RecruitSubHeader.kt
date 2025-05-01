
package com.cheeruplife.feature.recruit.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeTextDropdownButton
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.LifeBlack
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
internal fun RecruitSubHeader(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = modifier.fillMaxWidth().defaultHorizontalMargin(),
        ) {
            Row(
                modifier = modifier.align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = buildAnnotatedBannerTitle(137),
                    style = Typography.bodyMedium,
                    color = LifeGray,
                )
            }
            LifeTextDropdownButton(
                modifier = modifier.align(Alignment.CenterEnd),
                title = "등록순",
                onClick = {},
            )
        }
        Margin(height = Dimens.Margin8)
        HorizontalDivider(
            color = LifeGray100,
        )
    }
}

@Composable
private fun buildAnnotatedBannerTitle(
    count: Int
): AnnotatedString {
    return remember {
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = LifeBlack,
                    fontWeight = FontWeight.ExtraBold,
                )
            ) {
                append("$count")
            }
            append(" 건")
        }
    }
}

@Preview(name = "RecruitSubHeader")
@Composable
private fun PreviewRecruitSubHeader() {
    RecruitSubHeader()
}