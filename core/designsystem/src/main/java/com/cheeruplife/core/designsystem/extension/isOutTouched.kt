package com.cheeruplife.core.designsystem.extension

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect

fun Offset.isOutTouched(bound: Rect?): Boolean {
    val isInTouched = bound?.contains(this) ?: false
    return isInTouched.not()
}