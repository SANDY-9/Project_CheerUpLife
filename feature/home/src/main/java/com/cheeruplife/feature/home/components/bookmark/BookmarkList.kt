package com.cheeruplife.feature.home.components.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeJobOpeningHorizontalCard
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R

private const val MAX_HOME_BOOKMARK_ITEM_COUNT = 5
@Composable
internal fun BookmarkListView(
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val annotatedBookmarkDesc = buildAnnotatedBookmarkDesc()
    val maxItemCount = remember { MAX_HOME_BOOKMARK_ITEM_COUNT }
    Column {
        LazyRow(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = Dimens.Margin16,
            ),
            horizontalArrangement = Arrangement.spacedBy(Dimens.Margin16),
        ) {
            items(maxItemCount) { itemIndex ->
                val clickEvent = remember {
                    { onItemClick("$itemIndex") }
                }
                LifeJobOpeningHorizontalCard(
                    onItemClick = clickEvent,
                )
            }
        }
        Margin(height = Dimens.Margin4)
        Row(
            modifier = modifier.defaultHorizontalMargin(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = modifier.size(Dimens.Size16),
                imageVector = Icons.Rounded.Info,
                tint = LifeGray400,
                contentDescription = null,
            )
            Margin(width = Dimens.Margin2)
            Text(
                text = annotatedBookmarkDesc,
                style = Typography.labelSmall,
                color = LifeGray700,
            )
        }
    }
}

@Composable
private fun buildAnnotatedBookmarkDesc(): AnnotatedString {
    val desc1 = stringResource(R.string.home_bookmark_desc1)
    val desc2 = stringResource(
        id = R.string.home_bookmark_desc2,
        MAX_HOME_BOOKMARK_ITEM_COUNT,
    )
    val desc3 = stringResource(R.string.home_bookmark_desc3)
    return remember {
        buildAnnotatedString {
            append("$desc1 ")
            withStyle(
                style = SpanStyle(
                    color = LifeRed,
                    fontWeight = FontWeight.Bold,
                )
            ) {
                append(desc2)
            }
            append(desc3)
        }
    }
}

@Preview(name = "BookmarkListView")
@Composable
private fun PreviewBookmarkListView() {
    CheerUpLifeTheme {
        BookmarkListView({})
    }
}