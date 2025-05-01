package com.cheeruplife.feature.search.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.component.LifeSearchToolBar
import com.cheeruplife.feature.search.R

@Composable
internal fun SearchTitleBar(
    focusManager: FocusManager,
    focusRequester: FocusRequester,
    onNavigateBack: () -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var query by rememberSaveable { mutableStateOf("") }
    val inputChangeEvent = remember {
        { input: String -> query = input }
    }
    val searchEvent = remember {
        { onSearch(query) }
    }
    LifeSearchToolBar(
        modifier = modifier,
        query = query,
        focusManager = focusManager,
        focusRequester = focusRequester,
        placeholder = stringResource(R.string.search_input_placeholder),
        onInputChange = inputChangeEvent,
        onSearch = searchEvent,
        onNavigate = onNavigateBack,
    )

}

@Preview(name = "SearchToolbar")
@Composable
private fun PreviewSearchToolbar() {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    SearchTitleBar(
        focusManager = focusManager,
        focusRequester = focusRequester,
        onNavigateBack = {},
        onSearch = {},
    )
}