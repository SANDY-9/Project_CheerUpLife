package com.cheeruplife.feature.home.components.bookmark

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeOutLineButton
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R

@Composable
internal fun BookmarkEmptyView(
    onBookmarkEmptyClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth().defaultHorizontalMargin(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = modifier.size(Dimens.Size112),
            painter = painterResource(com.cheeruplife.core.resources.R.drawable.img_interesting),
            contentDescription = null,
        )
        Margin(width = Dimens.Margin16)
        Column {
            Text(
                text = stringResource(R.string.home_bookmark_empty_desc),
                style = Typography.bodyLarge,
                color = LifeGray,
            )
            Margin(height = Dimens.Margin8)
            LifeOutLineButton(
                title = stringResource(R.string.home_bookmark_empty_nav),
                onClick = onBookmarkEmptyClick,
            )
        }
    }
}

@Preview(name = "BookmarkEmptyView")
@Composable
private fun PreviewBookmarkEmptyView() {
    CheerUpLifeTheme {
        BookmarkEmptyView(
            onBookmarkEmptyClick = {},
        )
    }
}