package com.cheeruplife.feature.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R
import com.cheeruplife.feature.home.components.information.BannerPager
import com.cheeruplife.feature.home.components.information.InformationMenu

@Composable
internal fun HomeInformationView(
    onBannerItemClick: (String) -> Unit,
    onInformationMenuClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin(),
    ) {
        Title()
        Margin(height = Dimens.Margin12)
        Content(
            onBannerItemClick = onBannerItemClick,
            onMenuClick = onInformationMenuClick,
        )
    }
}

@Composable
private fun Title() {
    Text(
        text = buildAnnotatedBannerTitle(),
        style = Typography.titleLarge
    )
}

@Composable
private fun buildAnnotatedBannerTitle(): AnnotatedString {
    val title1 = stringResource(R.string.home_information_title1)
    val title2 = stringResource(R.string.home_information_title2)
    val title3 = stringResource(R.string.home_information_title3)
    return remember {
        buildAnnotatedString {
            append("$title1 ")
            withStyle(
                style = SpanStyle(
                    color = LifeRed,
                )
            ) {
                append(title2)
            }
            append(" $title3")
        }
    }
}

@Composable
private fun Content(
    onBannerItemClick: (String) -> Unit,
    onMenuClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        BannerPager(
            onBannerItemClick = onBannerItemClick,
        )
        Margin(height = Dimens.Margin12)
        InformationMenu(
            onMenuClick = onMenuClick,
        )
    }
}

@Preview(name = "HomeInformationView")
@Composable
private fun PreviewHomeInformationView() {
    CheerUpLifeTheme {
        HomeInformationView(
            onBannerItemClick = { },
            onInformationMenuClick = { },
        )
    }
}