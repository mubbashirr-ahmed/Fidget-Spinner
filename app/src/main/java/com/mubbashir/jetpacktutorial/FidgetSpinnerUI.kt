package com.mubbashir.jetpacktutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FidgetSpinnerUI() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fidget Spinner",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(vertical = 50.dp)
        )
        FidgetSpinner()

        InstructionText(
            text = "1. Drag to rotate in any direction", modifier = Modifier
                .padding(
                    top = 50.dp,
                    bottom = 2.dp,
                    start = 10.dp,
                    end = 10.dp
                )
                .align(Alignment.Start)
        )
        InstructionText(
            text = "2. Hold to stop", modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 10.dp)
                .align(Alignment.Start)
        )
        InstructionText(
            text = "3. Drag Quickly for higher speed", modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 10.dp)
                .align(Alignment.Start)
        )
    }
}