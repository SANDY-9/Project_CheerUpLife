package com.cheeruplife.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.compose.rememberConstraintsSizeResolver
import coil3.request.ImageRequest
import com.cheeruplife.core.designsystem.theme.LifeGray100

@Composable
fun LifeAsyncImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
) {
    val sizeResolver = rememberConstraintsSizeResolver()
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(url)
            .size(sizeResolver)
            .build(),
    )
    Image(
        modifier = modifier
            .background(color = LifeGray100)
            .then(sizeResolver),
        painter = painter,
        contentScale = contentScale,
        contentDescription = null,
    )
}

@Preview(name = "AsyncImage")
@Composable
private fun PreviewAsyncImage() {
    LifeAsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp),
        url = "https://images.pexels.com/photos/68507/spring-flowers-flowers-collage-floral-68507.jpeg",
    )
}