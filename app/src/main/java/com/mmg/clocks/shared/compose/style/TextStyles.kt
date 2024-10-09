package com.mmg.clocks.shared.compose.style

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.mmg.clocks.R

object TextStyles {

    fun montserrat(
        color: Color = Color.Unspecified,
        fontSize: TextUnit = TextUnit.Unspecified,
        fontWeight: FontWeight = FontWeight.Normal,
    ): TextStyle {
        return TextStyle(
            platformStyle = PlatformTextStyle(false),
            fontFamily = FontFamily(Font(R.font.montserrat)),
            fontSize = fontSize,
            color = color,
            fontWeight = fontWeight
        )
    }

}