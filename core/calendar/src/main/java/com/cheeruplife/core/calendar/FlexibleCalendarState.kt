package com.cheeruplife.core.calendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.pointer.PointerInputChange
import com.cheeruplife.core.calendar.model.CalendarType
import com.cheeruplife.core.calendar.model.ScrollState

class FlexibleCalendarState {

    var type by mutableStateOf(CalendarType.EXPANDED_CALENDAR)
        private set

    var fraction by mutableFloatStateOf(1f)
        private set

    private var scrollState by mutableStateOf(ScrollState.NONE)

    private fun updateType() {
        type = when {
            fraction > 0.5f -> CalendarType.EXPANDED_CALENDAR
            fraction > 0.1f -> CalendarType.NORMAL_CALENDAR
            else -> CalendarType.SMALL_CALENDAR
        }
    }

    fun onVerticalDrag(change: PointerInputChange, dragAmount: Float) {
        if(dragAmount > 0 && fraction < 1f) {
            fraction += 0.01f
            scrollState = ScrollState.DOWN_SCROLL
        }
        if(dragAmount < 0 && fraction > 0.1f) {
            fraction -= 0.01f
            scrollState = ScrollState.UP_SCROLL
        }
        updateType()
    }

    fun onDragEnd()  {
        fraction = when {
            fraction > 0.5f -> if(scrollState == ScrollState.UP_SCROLL) 0.5f else 1f
            fraction > 0.1f -> if(scrollState == ScrollState.UP_SCROLL) 0.1f else 0.5f
            else -> 0.1f
        }
        scrollState = ScrollState.NONE
        updateType()
    }

}

@Composable
fun rememberFlexibleCalendarState(): FlexibleCalendarState {
    val scope = rememberCoroutineScope()
    val state = remember {
        FlexibleCalendarState()
    }
    return state
}