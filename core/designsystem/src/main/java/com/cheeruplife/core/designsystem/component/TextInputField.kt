package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.extension.addFocusCleaner
import com.cheeruplife.core.designsystem.extension.showToast
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray500
import com.cheeruplife.core.designsystem.theme.LifeGray700
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeSearchTextField(
    query: String,
    placeholder: String,
    focusManager: FocusManager,
    focusRequester: FocusRequester,
    onInputChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val searchEvent: (KeyboardActionScope.() -> Unit) = remember {
        {
            if(query.isNotBlank()) {
                onSearch()
                focusManager.clearFocus()
            }
            else {
                context.showToast(QUERY_EMPTY_MESSAGE)
            }
        }
    }
    val clearEvent = remember {
        { _: Offset ->
            focusRequester.requestFocus()
            onInputChange("")
        }
    }
    TextField(
        modifier = modifier
            .addFocusCleaner(focusManager)
            .focusRequester(focusRequester),
        value = query,
        onValueChange = onInputChange,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = placeholder,
                style = Typography.bodyLarge,
                color = LifeGray700,
            )
        },
        trailingIcon = {
            Box(
                modifier = Modifier.background(
                    color = LifeGray500,
                    shape = CircleShape,
                ).size(
                    Dimens.Size20
                ).pointerInput(Unit) {
                    detectTapGestures(
                        onTap = clearEvent,
                    )
                },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = Modifier.size(
                        Dimens.Size18
                    ),
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        },
        /* search */
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = searchEvent,
        ),
    )
}
private const val QUERY_EMPTY_MESSAGE = "검색어를 입력하세요."

@Preview(name = "TextInputField")
@Composable
private fun PreviewTextInputField() {
    val focusManager = LocalFocusManager.current
    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }

    CheerUpLifeTheme {
        Column {
            LifeSearchTextField(
                query = input1,
                placeholder = "검색어를 입력하세요",
                focusManager = focusManager,
                focusRequester = focusRequester1,
                onInputChange = { input1 = it },
                onSearch = {},
            )
            LifeSearchTextField(
                query = input2,
                placeholder = "검색어를 입력하세요",
                focusManager = focusManager,
                focusRequester = focusRequester2,
                onInputChange = { input2 = it },
                onSearch = {},
            )
        }
    }
}