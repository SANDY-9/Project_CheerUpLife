package com.cheeruplife.feature.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.extension.defaultHorizontalMargin
import com.cheeruplife.core.designsystem.extension.defaultStartMargin
import com.cheeruplife.core.designsystem.extension.lifeToolbarHeight
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray500
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.core.resources.icons.MyIconPack
import com.cheeruplife.core.resources.icons.myiconpack.EditCalendar
import com.cheeruplife.core.resources.icons.myiconpack.NotificationActive
import com.cheeruplife.feature.home.R

@Composable
internal fun HomeTitleBar(
    onClickNotification: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
    ) {
        Row(
            modifier = modifier
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
        SearchButton(
            onClick = onClickSearch,
        )
        Margin(height = Dimens.Margin12)
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

@Composable
private fun SearchButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .defaultHorizontalMargin()
            .height(Dimens.Size48),
        onClick = onClick,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeRed,
        ),
    ) {
        Icon(
            imageVector = Icons.Rounded.Search,
            tint = LifeGray500,
            contentDescription = null,
        )
        Margin(width = Dimens.Margin8)
        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(R.string.home_search_title),
            style = Typography.bodyLarge.copy(
                color = LifeGray,
            ),
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
            onClickSearch = {},
        )
    }
}