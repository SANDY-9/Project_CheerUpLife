package com.cheeruplife.core.calendar.utils

import androidx.compose.ui.graphics.Color
import com.cheeruplife.core.designsystem.theme.LifeBlue
import com.cheeruplife.core.designsystem.theme.LifeGray600
import com.cheeruplife.core.designsystem.theme.LifePureRed
import com.cheeruplife.core.model.enums.DayOfWeek

internal fun DayOfWeek.color(): Color {
    return when(this) {
        DayOfWeek.SUNDAY -> LifePureRed
        DayOfWeek.SATURDAY -> LifeBlue
        else -> LifeGray600
    }
}