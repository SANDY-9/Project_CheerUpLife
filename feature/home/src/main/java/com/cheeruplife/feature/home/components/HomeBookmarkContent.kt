package com.cheeruplife.feature.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeTextButton
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R
import com.cheeruplife.feature.home.components.bookmark.BookmarkEmptyView
import com.cheeruplife.feature.home.components.bookmark.BookmarkListView

@Composable
internal fun HomeBookmarkContent(
    isBookmarkNotEmpty: Boolean,
    onBookmarkClick: () -> Unit,
    onBookmarkItemClick: (String) -> Unit,
    onBookmarkEmptyClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        BookmarkTitle(
            isBookmarkNotEmpty = isBookmarkNotEmpty,
            onBookmarkClick = onBookmarkClick,
        )
        Margin(height = Dimens.Margin12)
        when {
            isBookmarkNotEmpty -> BookmarkListView(
                onItemClick = onBookmarkItemClick,
            )
            else -> BookmarkEmptyView(
                onBookmarkEmptyClick = onBookmarkEmptyClick,
            )
        }
    }
}

@Composable
private fun BookmarkTitle(
    isBookmarkNotEmpty: Boolean,
    onBookmarkClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin()
    ) {
        Text(
            modifier = modifier.align(Alignment.CenterStart),
            text = stringResource(R.string.home_bookmark_title),
            style = Typography.titleLarge
        )
        if(isBookmarkNotEmpty) {
            LifeTextButton(
                modifier = modifier.align(Alignment.CenterEnd),
                title = stringResource(R.string.home_bookmark_more),
                onClick = onBookmarkClick,
            )
        }
    }
}

@Preview(name = "HomeBookmarkContent")
@Composable
private fun PreviewHomeBookmarkContent() {
    var isBookmarkNotEmpty by remember { mutableStateOf(true) }
    val clickEvent = remember {
        { isBookmarkNotEmpty = !isBookmarkNotEmpty }
    }
    CheerUpLifeTheme {
        HomeBookmarkContent(
            isBookmarkNotEmpty = isBookmarkNotEmpty,
            onBookmarkClick = clickEvent,
            onBookmarkItemClick = {},
            onBookmarkEmptyClick = clickEvent,
        )
    }
}