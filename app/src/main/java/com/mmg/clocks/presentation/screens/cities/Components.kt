package com.mmg.clocks.presentation.screens.cities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mmg.clocks.domain.data.City

@Composable
fun CityItem(city: City, onClick: (City) -> Unit) {
    Text(
        text = city.name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 8.dp)
            .clickable { onClick(city) },
        textAlign = TextAlign.Start
    )
}