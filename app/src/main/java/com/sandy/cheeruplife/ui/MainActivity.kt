package com.sandy.cheeruplife.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cheeruplife.core.designsystem.theme.CheerUpLifeTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val cheerUpLifeAppState = rememberHandsUpAppState()
            CheerUpLifeTheme {
                CheerUpLifeMainApp(
                    appState = cheerUpLifeAppState,
                    startDestination = StartRoute,
                )
            }
        }
    }
}

@Serializable object StartRoute