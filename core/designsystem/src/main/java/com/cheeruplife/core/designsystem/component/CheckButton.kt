package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeCheckButton(
    title: String,
    selected: Boolean,
    onSelectChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectChangeEvent = { onSelectChange(!selected) }
    when {
        selected -> SelectedCheckButton(
            modifier = modifier,
            title = title,
            onClick = selectChangeEvent,
        )
        else -> UnselectedOutlineCheckButton(
            modifier = modifier,
            title = title,
            onClick = selectChangeEvent,
        )
    }
}

@Composable
private fun UnselectedOutlineCheckButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier.height(Dimens.Size32),
        onClick = onClick,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeGray400,
        ),
        contentPadding = PaddingValues(
            horizontal = Dimens.Margin16,
        ),
    ) {
        Text(
            text = title,
            style = Typography.bodyMedium.copy(
                color = LifeGray,
                fontWeight = FontWeight.Medium,
            ),
        )
    }
}

@Composable
private fun SelectedCheckButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier.height(Dimens.Size32),
        onClick = onClick,
        border = BorderStroke(
            width = Dimens.Size1,
            color = LifeRed,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = LifeRed,
            contentColor = Color.White,
        ),
        contentPadding = PaddingValues(
            horizontal = Dimens.Margin16,
        ),
    ) {
        Text(
            text = title,
            style = Typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
            ),
        )
    }
}

@Preview(name = "CheckButton")
@Composable
private fun PreviewCheckButton() {
    LifeCheckButton(
        title = "체크버튼",
        selected = true,
        onSelectChange = {},
    )
}