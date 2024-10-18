package com.mubbashir.jetpacktutorial

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InstructionText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = "2. Hold to stop",
        fontSize = 16.sp,
        fontFamily = FontFamily.Serif,
        modifier = modifier
    )
}