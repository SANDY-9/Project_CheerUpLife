package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.extension.lifeToolbarHeight

@Composable
fun LifeSearchToolBar(
    query: String,
    placeholder: String,
    focusManager: FocusManager,
    focusRequester: FocusRequester,
    onInputChange: (String) -> Unit,
    onNavigate: () -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .lifeToolbarHeight(),
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
        LifeSearchTextField(
            modifier = modifier.fillMaxWidth().padding(start = Dimens.Size32),
            query = query,
            placeholder = placeholder,
            focusManager = focusManager,
            focusRequester = focusRequester,
            onInputChange = onInputChange,
            onSearch = onSearch,
        )
    }
}

@Preview(name = "SearchToolBar")
@Composable
private fun PreviewSearchToolBar() {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var input by remember { mutableStateOf("") }
    LifeSearchToolBar(
        query = input,
        placeholder = "검색어를 입력해주세요",
        focusManager = focusManager,
        focusRequester = focusRequester,
        onInputChange = { input = it },
        onSearch = {},
        onNavigate = {},
    )
}