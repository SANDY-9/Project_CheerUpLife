package com.cheeruplife.feature.search

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    SearchScreen(

    )
}

@Composable
private fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "SearchScreen")
    }
}

@Preview(name = "SearchScreen")
@Composable
private fun PreviewSearchScreen() {
    SearchScreen()
}