package com.cheeruplife.feature.recruit

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.component.LifeScrollUpFloatingButton
import com.cheeruplife.feature.recruit.components.RecruitHeader
import com.cheeruplife.feature.recruit.components.RecruitList
import com.cheeruplife.feature.recruit.components.RecruitToolbar

@Composable
internal fun RecruitRoute(
    onNavigateBack: () -> Unit,
    onRecruitItemClick: (String) -> Unit,
) {
    RecruitScreen(
        onNavigateBack = onNavigateBack,
        onRecruitItemClick = onRecruitItemClick,
    )
}

@Composable
private fun RecruitScreen(
    onNavigateBack: () -> Unit,
    onRecruitItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()
    var enableScrollUp by remember { mutableStateOf(false) }
    LaunchedEffect(lazyListState) {
        snapshotFlow { lazyListState.firstVisibleItemScrollOffset }
            .collect {
                val scrollOffset = lazyListState.firstVisibleItemScrollOffset
                enableScrollUp = scrollOffset > 0
            }
    }

    var scrollUp by remember { mutableStateOf(false) }
    val scrollUpEvent = remember {
        { scrollUp = true }
    }
    LaunchedEffect(scrollUp) {
        if(scrollUp) {
            lazyListState.animateScrollToItem(0)
            scrollUp = false
        }
    }
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
        ) {
            RecruitToolbar(
                onNavigateBack = onNavigateBack,
            )
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                state = lazyListState,
            ) {
                stickyHeader {
                    RecruitHeader()
                }
                item {
                    RecruitList(
                        onRecruitItemClick = onRecruitItemClick,
                    )
                }
            }
        }
        AnimatedVisibility(
            modifier = modifier
                .padding(
                    end = Dimens.Margin24,
                    bottom = Dimens.Margin24,
                )
                .align(Alignment.BottomEnd),
            visible = enableScrollUp,
            enter = EnterTransition.None,
            exit = fadeOut(
                animationSpec = tween(durationMillis = 200)
            ),
        ) {
            LifeScrollUpFloatingButton(
                onClick = scrollUpEvent,
            )
        }
    }
}


@Preview(name = "RecruitScreen")
@Composable
private fun PreviewRecruitScreen(
    onNavigateBack: () -> Unit = {},
    onRecruitItemClick: (String) -> Unit = {},
) {
    RecruitScreen(
        onNavigateBack = onNavigateBack,
        onRecruitItemClick = onRecruitItemClick,
    )
}