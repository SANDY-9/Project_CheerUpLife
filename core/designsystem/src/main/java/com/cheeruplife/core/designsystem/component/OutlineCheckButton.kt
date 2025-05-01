package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography

@Composable
fun LifeOutlineCheckButton(
    title: String,
    selected: Boolean,
    onSelectChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectChangeEvent = { onSelectChange(!selected) }
    when {
        selected -> SelectedOutlineCheckButton(
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
private fun SelectedOutlineCheckButton(
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
        contentPadding = PaddingValues(
            horizontal = Dimens.Margin12,
        ),
    ) {
        Icon(
            modifier = Modifier.size(Dimens.Size16),
            imageVector = Icons.Rounded.CheckCircle,
            tint = LifeRed,
            contentDescription = null,
        )
        Margin(width = Dimens.Margin4)
        Text(
            text = title,
            style = Typography.bodyMedium.copy(
                color = LifeRed,
                fontWeight = FontWeight.Medium,
            ),
        )
    }
}

@Preview(name = "CheckButton")
@Composable
private fun PreviewCheckButton() {
    var select by remember { mutableStateOf(true) }
    LifeOutlineCheckButton(
        title = "체크버튼",
        selected = select,
        onSelectChange = { select = !it },
    )
}