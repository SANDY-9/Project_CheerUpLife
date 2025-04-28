package com.cheeruplife.core.designsystem.extension

import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import com.cheeruplife.core.designsystem.common.Dimens

fun Modifier.lifeToolbarHeight(): Modifier {
    return this.height(Dimens.Size56)
}