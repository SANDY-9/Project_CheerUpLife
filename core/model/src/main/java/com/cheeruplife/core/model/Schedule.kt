package com.cheeruplife.core.model

data class Schedule(
    val date: Date,
    val content: String,
    val isCompleted: Boolean = false,
    val priority: Int = 0,
)
