
package com.cheeruplife.feature.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.component.LifeScheduleTextField
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.feature.schedule.R

@Composable
internal fun ScheduleInputButton(
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var input by remember { mutableStateOf("") }
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        /*LifeSearchTextField(
            modifier = modifier.weight(1f),
            query = input,
            placeholder = stringResource(R.string.schedule_add_placeholder, 5, 5),
            focusManager = focusManager,
            focusRequester = focusRequester,
            onInputChange = { input = it },
            onSearch = {},
        )*/
        Box(
            modifier = modifier
                .background(
                    color = LifeGray100,
                    shape = RoundSquare.Large,
                ),
        ) {
            LifeScheduleTextField(
                modifier = modifier.fillMaxWidth(),
            query = input,
            placeholder = stringResource(R.string.schedule_add_placeholder, 5, 5),
            focusManager = focusManager,
            focusRequester = focusRequester,
            onInputChange = { input = it },
            onDone = {},
        )
        }
        /*Margin(width = Dimens.Margin8)
        FilledIconButton (
            modifier = modifier.size(Dimens.Size56),
            shape = RoundSquare.Large,
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = Color.White,
                containerColor = LifeRed,
            ),
            *//*border = BorderStroke(
                width = Dimens.Size1,
                color = LifeRed
            ),*//*
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null,
            )
        }*/
    }
}

@Preview(name = "ScheduleInputButton")
@Composable
private fun PreviewScheduleInputButton() {
    CheerUpLifeTheme {
        ScheduleInputButton()
    }
}