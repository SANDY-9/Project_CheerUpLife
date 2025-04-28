package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
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
    onInputChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    TextField(
        modifier = modifier
            .fillMaxSize()
            .addFocusCleaner(focusManager),
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
                modifier = modifier.background(
                    color = LifeGray500,
                    shape = CircleShape,
                ).size(
                    Dimens.Size20
                ).pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            onInputChange("")
                        }
                    )
                },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = modifier.size(
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
            onSearch = {
                if(query.isNotBlank()) {
                    onSearch()
                    focusManager.clearFocus()
                }
                else {
                    context.showToast(QUERY_EMPTY_MESSAGE)
                }
            }
        ),
    )
}
private const val QUERY_EMPTY_MESSAGE = "검색어를 입력해주세요."

@Preview(name = "TextInputField")
@Composable
private fun PreviewTextInputField() {

    val focusManager = LocalFocusManager.current
    var input by remember { mutableStateOf("") }

    CheerUpLifeTheme {
        LifeNavigateToolbar(
            title = "",
            onNavigate = {},
        ) {
            Margin(width = Dimens.Margin32)
            LifeSearchTextField(
                query = input,
                placeholder = "검색어를 입력해주세요",
                focusManager = focusManager,
                onInputChange = {
                    input = it
                },
                onSearch = {},
            )
        }
    }
}