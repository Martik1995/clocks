package com.mmg.clocks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mmg.clocks.presentation.screens.MainScreen
import com.mmg.clocks.shared.compose.ClocksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClocksTheme {

                val navController = rememberNavController()

                NavHost(navController, startDestination = "start") {
                    composable("start") { MainScreen(navController) }
                    composable("details/{itemId}") { backStackEntry ->

                    }
                }
            }
        }

    }
}