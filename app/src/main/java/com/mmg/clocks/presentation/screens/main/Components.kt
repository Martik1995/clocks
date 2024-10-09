package com.mmg.clocks.presentation.screens.main

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.mmg.clocks.R
import com.mmg.clocks.shared.compose.style.Black
import com.mmg.clocks.shared.compose.style.TextStyles
import com.mmg.clocks.shared.compose.utils.asStringResource

@Composable
fun ColumnScope.SelectCityButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Black)
    ) {
        Text(
            text = R.string.text_select_city.asStringResource(),
            color = Color.White
        )
    }
}

@Composable
fun ColumnScope.MainScreenText(text: String, color: Color, fontSize: TextUnit, fontWeight: FontWeight) {
    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = text,
        style = TextStyles.montserrat(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight
        ),
        textAlign = TextAlign.Center
    )
}