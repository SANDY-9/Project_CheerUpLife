package com.sandy.cheeruplife.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import com.cheeruplife.feature.home.navigation.HomeRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val cheerUpLifeAppState = rememberHandsUpAppState()
            CheerUpLifeTheme {
                CheerUpLifeMainApp(
                    appState = cheerUpLifeAppState,
                    startDestination = HomeRoute,
                )
            }
        }
    }
}