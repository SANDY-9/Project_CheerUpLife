package com.cheeruplife.feature.home.components.information

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeTouchReactiveMenu
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.feature.home.model.InformationMenu

private val informationMenuEntry = InformationMenu.entries
@Composable
internal fun InformationMenu(
    onMenuClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin(),
    ) {
        informationMenuEntry.forEachIndexed { index, item ->
            val menuSelectEvent = remember {
                { onMenuClick(item.label) }
            }
            LifeTouchReactiveMenu(
                icon = item.imageVector,
                label = item.label,
                onClick = menuSelectEvent,
            )
            if(index != informationMenuEntry.lastIndex) {
                Margin(modifier = modifier.weight(1f),)
            }
        }
    }
}

@Preview(name = "InformationMenu")
@Composable
private fun PreviewInformationMenu() {
    InformationMenu(
        onMenuClick = {},
    )
}