package com.cheeruplife.feature.schedule.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.component.LifeNavigateAnnotatedTitleToolbar
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.feature.schedule.R

@Composable
internal fun ScheduleToolbar(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LifeNavigateAnnotatedTitleToolbar(
            title = buildAnnotatedScheduleTitle(),
            onNavigate = onNavigateBack,
        )
    }
}

@Composable
private fun buildAnnotatedScheduleTitle(): AnnotatedString {
    val title1 = stringResource(R.string.schedule_title_anno1)
    val title2 = stringResource(R.string.schedule_title_anno2)
    val title3 = stringResource(R.string.schedule_title_anno3)
    return remember {
        buildAnnotatedString {
            append("$title1")
            withStyle(
                style = SpanStyle(
                    color = LifeRed,
                )
            ) {
                append(title2)
            }
            append("$title3")
        }
    }
}

@Preview(name = "ScheduleToolbar")
@Composable
private fun PreviewScheduleToolbar() {
    ScheduleToolbar(
        onNavigateBack = {},
    )
}