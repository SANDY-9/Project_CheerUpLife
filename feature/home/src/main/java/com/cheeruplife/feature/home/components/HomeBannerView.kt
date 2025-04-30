package com.cheeruplife.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.LifeGray900
import com.cheeruplife.core.designsystem.theme.LifePastelBlue
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R

@Composable
internal fun HomeBannerView(
    onBannerClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        SeoulYouthBanner(
            onClick = onBannerClick,
        )
    }
}

@Composable
private fun SeoulYouthBanner(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.Size112)
            .background(color = LifePastelBlue),
    ) {
        Column(
            modifier = modifier
                .align(Alignment.CenterVertically)
                .padding(start = Dimens.Margin28)
        ) {
            Text(
                text = stringResource(R.string.home_seoul_youth_message),
                style = Typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (-0.9).sp
                ),
                color = LifeGray900,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = modifier.size(
                        width = 120.dp,
                        height = 32.dp,
                    ),
                    painter = painterResource(com.cheeruplife.core.resources.R.drawable.img_youth_seoul_logo),
                    contentDescription = null,
                )
                Margin(width = Dimens.Margin4)
                IconButton(
                    onClick = onClick,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                        contentDescription = null,
                        tint = LifeGray900,
                    )
                }
            }
        }
        Image(
            modifier = modifier.align(Alignment.Bottom),
            painter = painterResource(
                com.cheeruplife.core.resources.R.drawable.img_youth_seoul_illust
            ),
            contentDescription = null,
        )
    }
}

@Preview(name = "HomeBannerView")
@Composable
private fun PreviewHomeBannerView() {
    HomeBannerView(
        onBannerClick = {},
    )
}