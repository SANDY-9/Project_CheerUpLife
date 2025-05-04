package com.cheeruplife.core.model

import com.cheeruplife.core.model.enums.ScheduleType

data class Schedule(
    val date: Date,
    val content: String,
    val type: ScheduleType = ScheduleType.NOT_COMPLETE,
    val priority: Int = 0,
)
