package com.cheeruplife.feature.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeTextButton
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.extension.defaultVerticalMargin
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.search.R

@Composable
internal fun SearchHistoryView(
    historyList: List<String>,
    onHistoryReset: () -> Unit,
    onSearch: (String) -> Unit,
    onHistoryClear: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin()
            .defaultVerticalMargin(),
    ) {
        Title(
            onHistoryReset = onHistoryReset,
        )
        Margin(height = Dimens.Margin16)
        SearchHistoryList(
            historyList = historyList,
            onSearch = onSearch,
            onClear = onHistoryClear,
        )
    }
}

@Composable
private fun Title(
    onHistoryReset: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = modifier.align(Alignment.CenterStart),
            text = stringResource(R.string.search_history_title),
            style = Typography.titleLarge,
        )
        LifeTextButton(
            modifier = modifier.align(Alignment.BottomEnd),
            title = stringResource(R.string.search_history_clear),
            onClick = onHistoryReset,
        )
    }
}

@Preview(name = "SearchHistoryView")
@Composable
private fun PreviewSearchHistoryView() {
    SearchHistoryView(
        historyList = listOf("안녕하세요", "안녕", "안녕하세여", "안녕하", "안녕하세여여여"),
        onHistoryReset = {},
        onSearch = {},
        onHistoryClear = {},
    )
}