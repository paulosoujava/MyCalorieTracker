package com.paulo.mycalorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.paulo.onboarding_presentation.welcome.WelcomeScreen
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                WelcomeScreen()
            }
        }
    }
}
