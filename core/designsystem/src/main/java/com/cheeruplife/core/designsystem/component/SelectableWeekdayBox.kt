package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.Margin
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.theme.LifeGray
import com.cheeruplife.core.designsystem.theme.LifeGray100
import com.cheeruplife.core.designsystem.theme.LifeGray400
import com.cheeruplife.core.designsystem.theme.LifeRed
import com.cheeruplife.core.designsystem.theme.Typography
import java.util.Calendar

private val weekdays = listOf(
    "일",
    "월",
    "화",
    "수",
    "목",
    "금",
    "토",
)

/**
 * @param onSelect 선택한 요일(Day of Week)을 전달하는 콜백.
 * Calendar의 Day of Week(Int)값를 리턴한다.
 * * 일요일은 1, 월요일은 2, 화요일은 3, 수요일은 4, 목요일은 5, 금요일은 6, 토요일은 7
 */
@Composable
fun LifeSelectableWeekdayBox(
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
    weekday: List<String> = weekdays,
) {
    val todayPosition = remember { getTodayPosition() }
    var selectPosition by remember { mutableIntStateOf(todayPosition) }
    val selectEvent = remember {
        { position: Int ->
            selectPosition = position
            onSelect(position + 1)
        }
    }
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
        ) {
            WeekdayDivider()
            Row {
                weekdays.forEachIndexed { position, day ->
                    WeekdayItem(
                        modifier = modifier.weight(1f),
                        day = day,
                        position = position,
                        selected = position == selectPosition,
                        onClick = selectEvent,
                    )
                }
            }
        }
        Margin(height = Dimens.Margin2)
        Row {
            repeat(weekday.size) { position ->
                val isToday = remember { position == todayPosition }
                WeekDayTodayItem(
                    modifier = modifier.weight(1f),
                    isToday = isToday,
                )
            }
        }
    }
}

@Composable
private fun WeekdayDivider(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.Size16)
            .padding(vertical = Dimens.Margin4)
            .background(
                color = LifeGray100,
                shape = RoundSquare.Small,
            ),
    )
}

@Composable
private fun WeekdayItem(
    day: String,
    selected: Boolean,
    position: Int,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val clickEvent = remember {
        { _: Offset -> onClick(position) }
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier.width(Dimens.Size24).pointerInput(Unit) {
                detectTapGestures(
                    onTap = clickEvent,
                )
            },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            when {
                selected -> SelectedWeekdayText(day = day)
                else -> UnselectedWeekdayText(day = day)
            }
            Margin(height = Dimens.Margin2)
            when {
                selected -> SelectedWeekdayCircle()
                else -> UnselectedWeekdayCircle()
            }
        }
    }
}

@Composable
private fun SelectedWeekdayText(
    day: String,
) {
    Text(
        text = day,
        style = Typography.labelLarge,
        color = LifeRed,
        fontWeight = FontWeight.Bold,
    )
}
@Composable
private fun UnselectedWeekdayText(
    day: String,
) {
    Text(
        text = day,
        style = Typography.labelLarge,
        color = LifeGray,
    )
}
@Composable
private fun SelectedWeekdayCircle(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(Dimens.Size16)
            .background(
                color = LifeRed,
                shape = CircleShape,
            )
    )
}
@Composable
private fun UnselectedWeekdayCircle(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(Dimens.Size16)
            .background(
                color = Color.White,
                shape = CircleShape,
            )
            .border(
                width = Dimens.Size1,
                color = LifeGray400,
                shape = CircleShape,
            )
    )
}

@Composable
private fun WeekDayTodayItem(
    isToday: Boolean,
    modifier: Modifier,
) {
    val alpha = remember {
        if(isToday) 1f else 0f
    }
    Text(
        modifier = modifier.alpha(alpha),
        text = "TODAY",
        textAlign = TextAlign.Center,
        style = Typography.labelSmall,
        color = LifeRed,
    )
}

private fun getTodayPosition(): Int {
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.DAY_OF_WEEK) - 1
}

@Preview(name = "SelectableWeekdayBox")
@Composable
private fun PreviewSelectableWeekdayBox() {
    LifeSelectableWeekdayBox(
        onSelect = {},
    )
}