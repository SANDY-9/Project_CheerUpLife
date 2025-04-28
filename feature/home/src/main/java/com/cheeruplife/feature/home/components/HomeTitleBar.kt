package com.cheeruplife.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.extension.defaultStartMargin
import com.cheeruplife.core.designsystem.extension.lifeToolbarHeight
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.resources.icons.MyIconPack
import com.cheeruplife.core.resources.icons.myiconpack.EditCalendar
import com.cheeruplife.core.resources.icons.myiconpack.NotificationActive

@Composable
internal fun HomeTitleBar(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .defaultStartMargin()
            .padding(end = Dimens.Margin8)
            .lifeToolbarHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppLogo()
        Margin(modifier = modifier.weight(1f))
        NotificationButton(onClick = onClickNotification)
        CalendarButton(onClick = onClickCalendar)
    }
}

@Composable
private fun AppLogo(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier.height(Dimens.Size32),
        painter = painterResource(id = com.cheeruplife.core.resources.R.drawable.app_logo_title),
        contentDescription = null,
    )
}

@Composable
private fun NotificationButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            imageVector = MyIconPack.NotificationActive,
            contentDescription = null,
        )
    }
}

@Composable
private fun CalendarButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(
            imageVector = MyIconPack.EditCalendar,
            contentDescription = null,
        )
    }
}

@Preview(name = "HomeTitleBar")
@Composable
private fun PreviewHomeTitleBar() {
    CheerUpLifeTheme {
        HomeTitleBar(
            onClickNotification = {},
            onClickCalendar = {},
        )
    }
}