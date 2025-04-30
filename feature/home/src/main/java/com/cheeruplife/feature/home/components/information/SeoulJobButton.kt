package com.cheeruplife.feature.home.components.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.component.LifeOutLineButton
import com.cheeruplife.core.designsystem.theme.LifeNavy
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R

@Composable
internal fun SeoulJobButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LifeOutLineButton(
        modifier = modifier.height(Dimens.Size42),
        onClick = onClick,
        content = {
            Row(
                modifier = modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    modifier = Modifier.height(Dimens.Size28).align(Alignment.Top),
                    painter = painterResource(com.cheeruplife.core.resources.R.drawable.img_seoul_logo),
                    contentDescription = null,
                )
                Margin(width = Dimens.Margin4)
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = stringResource(R.string.home_information_banner_seoul),
                    style = Typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
                    color = LifeNavy,
                )
            }
        }
    )
}
@Preview(name = "SeoulJobButton")
@Composable
private fun PreviewSeoulJobButton() {
    SeoulJobButton(
        onClick = {},
    )
}