package com.cheeruplife.feature.home.components.information

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.common.RoundSquare
import com.cheeruplife.core.designsystem.component.LifeAsyncImage
import com.cheeruplife.core.designsystem.component.LifePagerIndicator

@Composable
internal fun BannerPager(
    onBannerItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    totalItemCount: Int = 5,
) {
    val totalPage = remember { totalItemCount }
    val pagerState = rememberPagerState(
        pageCount = { totalPage }
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.Size165)
            .clip(RoundSquare.Medium),
    ) {
        HorizontalPager(
            state = pagerState,
            beyondViewportPageCount = 1,
        ) { page ->
            val itemClickEvent = remember(page) {
                { onBannerItemClick("태그") }
            }
            BannerItem(
                photoUrl = bannerItem[page],
                onItemClick = itemClickEvent,
            )
        }
        LifePagerIndicator(
            modifier = modifier.align(Alignment.BottomEnd).padding(
                end = Dimens.Margin12,
                bottom = Dimens.Margin8,
            ),
            currentPage = pagerState.currentPage + 1,
            totalPage = totalPage,
        )
    }
}

private val bannerItem = listOf(
    "http://good-job.co.kr/wp-content/uploads/2021/03/business1.png",
    "https://images.pexels.com/photos/68507/spring-flowers-flowers-collage-floral-68507.jpeg",
    "https://firebasestorage.googleapis.com/v0/b/practice-e29de.appspot.com/o/RIIZE.jpg?alt=media&token=ba7be06e-2d2a-4382-a7b1-8dc9d9485830",
    "http://good-job.co.kr/wp-content/uploads/2021/03/business1.png",
    "https://images.pexels.com/photos/68507/spring-flowers-flowers-collage-floral-68507.jpeg",
)
@Composable
private fun BannerItem(
    photoUrl: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        LifeAsyncImage(
            url = photoUrl,
            modifier = modifier
                .fillMaxSize()
                .clickable(
                    onClick = onItemClick
                ),
        )
    }
}

@Preview(name = "BannerPager")
@Composable
private fun PreviewBannerPager() {
   // BannerPager()
}