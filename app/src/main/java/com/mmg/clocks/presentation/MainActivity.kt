package com.mmg.clocks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mmg.clocks.navigation.Screen
import com.mmg.clocks.presentation.screens.cities.CitiesScreen
import com.mmg.clocks.presentation.screens.main.MainScreen
import com.mmg.clocks.shared.compose.style.ClocksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClocksTheme {

                val navController = rememberNavController()

                NavHost(navController, startDestination = Screen.Main.route) {
                    composable(Screen.Main.route) { MainScreen(navController) }
                    composable(Screen.Cities.route) { CitiesScreen(navController) }
                }
            }
        }

    }
}