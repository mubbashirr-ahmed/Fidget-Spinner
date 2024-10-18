package com.mubbashir.jetpacktutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.android.awaitFrame

@Composable
fun FidgetSpinner() {
    var velocity by remember { mutableStateOf(0f) }
    var angle by remember { mutableStateOf(0f) }
    val velocityTracker = remember { VelocityTracker() }
    val friction = 0.996f

    LaunchedEffect(Unit) {
        while (true) {
            if (velocity != 0f) {
                angle += kotlin.math.abs(velocity) / 60f

                velocity *= friction
                if (velocity < 0.1f && velocity > -0.1f) velocity = 0f
            }
            awaitFrame()
        }
    }

    Image(
        painter = painterResource(id = R.drawable.fidget),
        contentDescription = "Fidget",
        modifier = Modifier
            .size(200.dp)
            .graphicsLayer {
                rotationZ = angle % 360
            }
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset ->
                        velocityTracker.resetTracking()
                        velocityTracker.addPosition(0, offset)
                    },
                    onDrag = { change, _ ->
                        velocityTracker.addPosition(change.uptimeMillis, change.position)
                        change.consume()
                        val velocityT = velocityTracker.calculateVelocity()
                        velocity = velocityT.y
                    }
                )
            }
    )
}

