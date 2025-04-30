package com.cheeruplife.feature.home.components.information

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin

@Composable
internal fun LinkButtonList(
    onWork24Click: () -> Unit,
    onSeoulJobClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Work24Button(
            modifier = modifier.weight(1f),
            onClick = onWork24Click,
        )
        Margin(width = Dimens.Margin12)
        SeoulJobButton(
            modifier = modifier.weight(1f),
            onClick = onSeoulJobClick,
        )
    }
}

@Preview(name = "LinkButtonList")
@Composable
private fun PreviewLinkButtonList() {
    LinkButtonList(
        onWork24Click = {},
        onSeoulJobClick = {},
    )
}