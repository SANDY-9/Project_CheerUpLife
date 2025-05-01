package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.extension.lifeToolbarHeight
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeNavigateNoTitleToolbar(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .lifeToolbarHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = modifier
                .fillMaxHeight()
                .width(Dimens.Margin48),
            onClick = onNavigate,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = null,
            )
        }
        actions()
    }
}

@Composable
fun LifeNavigateTitleToolbar(
    title: String,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .lifeToolbarHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = modifier
                .fillMaxHeight()
                .width(Dimens.Margin48),
            onClick = onNavigate,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = null,
            )
        }
        Text(
            modifier = modifier.weight(1f),
            text = title,
            style = Typography.titleLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        actions()
    }
}

@Composable
fun LifeNavigateAnnotatedTitleToolbar(
    title: AnnotatedString,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .lifeToolbarHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = modifier
                .fillMaxHeight()
                .width(Dimens.Margin48),
            onClick = onNavigate,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = null,
            )
        }
        Text(
            modifier = modifier.weight(1f),
            text = title,
            style = Typography.titleLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        actions()
    }
}

@Preview(name = "Toolbar")
@Composable
private fun PreviewToolbar() {
    val annotatedString = buildAnnotatedString {
        append("취")
        withStyle(style = SpanStyle(color = LifeRed)) {
            append("UP")
        }
        append("로그")
    }
    CheerUpLifeTheme {
        Column {
            LifeNavigateNoTitleToolbar(
                onNavigate = {},
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = null,
                    )
                }
                Text(
                    text = "테스트 하고 있습니다."
                )
            }
            LifeNavigateTitleToolbar(
                title = "서울시 청년정책",
                onNavigate = {},
            )
            LifeNavigateAnnotatedTitleToolbar(
                title = annotatedString,
                onNavigate = {},
            )
        }
    }
}