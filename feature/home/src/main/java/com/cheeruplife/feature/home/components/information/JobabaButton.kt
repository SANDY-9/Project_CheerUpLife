package com.cheeruplife.feature.home.components.information

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.component.LifeOutLineButton
import com.cheeruplife.core.designsystem.theme.Typography
import com.cheeruplife.feature.home.R

@Composable
internal fun JobabaButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LifeOutLineButton(
        modifier = modifier.height(Dimens.Size42),
        onClick = onClick,
        content = {
            Image(
                modifier = modifier.height(Dimens.Size32),
                painter = painterResource(com.cheeruplife.core.resources.R.drawable.img_jobaba_logo),
                contentDescription = null,
            )
            Text(
                text = stringResource(R.string.home_information_banner_work24),
                style = Typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                ),
            )
        }
    )
}

@Preview(name = "JobabaButton")
@Composable
private fun PreviewJobabaButton() {
    JobabaButton(
        onClick = {},
    )
}