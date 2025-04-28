package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LifeSelectableBottomSheet(
    onReset: () -> Unit,
    onComplete: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable() (BoxScope.() -> Unit) = {},
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    var openBottomSheet by rememberSaveable { mutableStateOf(true) }
    val dismissRequest = remember {
        { openBottomSheet = false }
    }
    val scope = rememberCoroutineScope()
    val completeEvent: () -> Unit = remember {
        {
            scope.launch {
                bottomSheetState.hide()
            }.invokeOnCompletion {
                dismissRequest()
                onComplete()
            }
        }
    }
    if(openBottomSheet) {
        ModalBottomSheet(
            sheetState = bottomSheetState,
            containerColor = Color.White,
            onDismissRequest = dismissRequest,
        ) {
            Column(
                modifier = modifier.fillMaxWidth().padding(
                    start = Dimens.Margin12,
                    end = Dimens.Margin12,
                    bottom = Dimens.Margin16,
                ),
            ) {
                Box (
                    modifier = modifier.padding(horizontal = Dimens.Margin8),
                    content = content,
                )
                Margin(height = Dimens.Margin16)
                Row {
                    LifeOutLineButton(
                        modifier = modifier.fillMaxWidth(0.4f),
                        title = "초기화",
                        onClick = onReset,
                    )
                    Margin(width = Dimens.Margin10)
                    LifeButton(
                        modifier = modifier.fillMaxWidth(),
                        title = "적용하기",
                        onClick = completeEvent,
                    )
                }
            }
        }
    }
}

@Preview(name = "BottomSheet")
@Composable
private fun PreviewBottomSheet() {
    CheerUpLifeTheme {
        LifeSelectableBottomSheet(
            onReset = {},
            onComplete = {},
        ) {
            Column {
                Text(
                    text = "선택1"
                )
                Text(
                    text = "선택2"
                )
                Text(
                    text = "선택3"
                )
                Text(
                    text = "선택4"
                )
            }
        }
    }
}