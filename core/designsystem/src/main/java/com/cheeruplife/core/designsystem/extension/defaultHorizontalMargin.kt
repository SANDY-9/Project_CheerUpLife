package com.cheeruplife.core.designsystem.extension

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.cheeruplife.core.designsystem.common.Dimens

fun Modifier.defaultHorizontalMargin(): Modifier {
    return this.padding(horizontal = Dimens.Margin16)
}

fun Modifier.defaultStartMargin(): Modifier {
    return this.padding(start = Dimens.Margin16)
}

fun Modifier.defaultEndMargin(): Modifier {
    return this.padding(end = Dimens.Margin16)
}

fun Modifier.defaultVerticalMargin(): Modifier {
    return this.padding(vertical = Dimens.Margin16)
}