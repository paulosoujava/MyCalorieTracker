package com.paulo.mycalorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.paulo.core.navigation.Routes
import com.paulo.onboarding_presentation.welcome.WelcomeScreen
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme
import navigate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.WELCOME
                ){
                    composable(Routes.WELCOME){
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Routes.AGE){}
                    composable(Routes.GENDER){}
                    composable(Routes.HEIGHT){}
                    composable(Routes.WEIGHT){}
                    composable(Routes.NUTRIENT_GOAL){}
                    composable(Routes.GOAL){}
                    composable(Routes.ACTIVITY){}
                    composable(Routes.TRACKER_OVERVIEW){}
                    composable(Routes.SEARCH){}
                }
            }
        }
    }
}
