package com.cheeruplife.feature.schedule.components.schedulecard

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.extension.noRippleClickable
import com.cheeruplife.core.designsystem.extension.touchReactive
import com.cheeruplife.core.designsystem.theme.LifeRed

@Composable
internal fun ScheduleItemMenuButton(
    onCompleteClick: () -> Unit,
    onEditClick: () -> Unit,
    onRemoveClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = LifeRed,
    outTouch: Boolean? = null,
) {
    var menuVisible by remember { mutableStateOf(false) }
    val clickEvent = {
        menuVisible = !menuVisible
    }
    LaunchedEffect(outTouch) {
        if(outTouch == true) {
            menuVisible = false
        }
    }
    AnimatedContent(targetState = menuVisible) { visible ->
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            if(visible) {
                Icon(
                    modifier = modifier.touchReactive {
                        onCompleteClick()
                        clickEvent()
                    },
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = null,
                    tint = color,
                )
                Margin(width = Dimens.Margin4)
                Icon(
                    modifier = modifier.touchReactive {
                        onEditClick()
                        clickEvent()
                    },
                    imageVector = Icons.Rounded.Edit,
                    contentDescription = null,
                    tint = color,
                )
                Margin(width = Dimens.Margin4)
                Icon(
                    modifier = modifier.touchReactive {
                        onRemoveClick()
                        clickEvent()
                    },
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = null,
                    tint = color,
                )
            }
            else {
                Icon(
                    modifier = modifier.noRippleClickable(onClick = clickEvent),
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    contentDescription = null,
                    tint = color,
                )
            }
        }
    }
}

@Preview(name = "MoreMenuButton")
@Composable
private fun PreviewMoreMenuButton() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
    ) {
        ScheduleItemMenuButton(
            onCompleteClick = {},
            onEditClick = {},
            onRemoveClick = {},
            outTouch = true,
        )
    }
}