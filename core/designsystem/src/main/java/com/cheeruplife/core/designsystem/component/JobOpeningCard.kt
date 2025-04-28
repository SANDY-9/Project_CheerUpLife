package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.core.designsystem.theme.LifeGray400

@Composable
fun LifeJobOpeningHorizontalCard(
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Column (
        modifier = modifier
            .width(Dimens.Size112)
            .wrapContentHeight()
            .background(
                color = Color.White,
                shape = RoundSquare.Medium,
            )
            .border(
                width = Dimens.Size1,
                color = LifeGray400,
                shape = RoundSquare.Medium,
            )
            .clip(RoundSquare.Medium)
            .clickable(onClick = onItemClick)
            .padding(
                vertical = Dimens.Margin12,
                horizontal = Dimens.Margin16,
            ),
        content = content,
    )
}

@Composable
fun LifeJobOpeningVerticalCard(
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color.White,
                shape = RoundSquare.Large,
            )
            .border(
                width = Dimens.Size1,
                color = LifeGray400,
                shape = RoundSquare.Large,
            )
            .clip(RoundSquare.Large)
            .clickable(onClick = onItemClick)
            .padding(Dimens.Margin16),
        content = content,
    )
}

@Preview(name = "Card")
@Composable
private fun PreviewCard() {
    CheerUpLifeTheme {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth().padding(vertical = Dimens.Margin16),
                    contentPadding = PaddingValues(
                        horizontal = Dimens.Margin16,
                    ),
                    horizontalArrangement = Arrangement.spacedBy(Dimens.Margin16),
                ) {
                    items(5) {
                        LifeJobOpeningHorizontalCard(
                            onItemClick = {},
                        ) {
                            Text(
                                text = "Life Job",
                                fontSize = 12.sp,
                            )
                            Text(
                                text = "Job Opening",
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "Life Job Opening",
                                fontSize = 14.sp,
                            )
                            Text(
                                text = "Job Opening",
                                fontSize = 12.sp,
                            )
                            Text(
                                text = "Opening",
                                fontSize = 10.sp,
                            )
                        }
                    }
                }
            }
            items(8) {
                Box(
                    modifier = Modifier.padding(
                        start = Dimens.Margin16,
                        end = Dimens.Margin16,
                        bottom = Dimens.Margin16,
                    )
                ) {
                    LifeJobOpeningVerticalCard(
                        onItemClick = {},
                    ) {
                        Text(
                            text = "Life Job Opening",
                            fontSize = 12.sp,
                        )
                        Text(
                            text = "Life Job Opening",
                            fontSize = 18.sp,
                        )
                        Text(
                            text = "Life Job Opening Life Job Opening Life Job Opening",
                            fontSize = 16.sp,
                        )
                        Text(
                            text = "Life Job Opening",
                            fontSize = 14.sp,
                        )
                        Text(
                            text = "Life Job Opening Life Job Opening",
                            fontSize = 14.sp,
                        )
                    }
                }
            }
        }
    }
}