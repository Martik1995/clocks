package com.mmg.clocks.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mmg.clocks.navigation.Screen
import com.mmg.clocks.presentation.base.BaseScreen
import com.mmg.clocks.shared.compose.style.Black
import com.mmg.clocks.shared.compose.style.Gray
import com.mmg.clocks.shared.compose.utils.SpacerHeight
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel = koinViewModel(
        parameters = { parametersOf(navController) }
    )
) {
    BaseScreen(
        viewModel = viewModel,
        loader = null,
        data = { state, _ ->
            Box(modifier = Modifier.align(Alignment.Center)) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {

                    MainScreenText(
                        text = state.selectedCity.name,
                        color = Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    if (state.time.isNotBlank()) {
                        MainScreenText(
                            text = state.time,
                            color = Gray,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    } else {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.CenterHorizontally),
                            color = Black,
                            strokeWidth = 2.dp
                        )
                    }

                    SpacerHeight(16.dp)

                    SelectCityButton {
                        navController.navigate(Screen.Cities.route)
                    }

                }
            }
        }
    )
}