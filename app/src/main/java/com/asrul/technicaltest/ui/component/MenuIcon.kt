package com.asrul.technicaltest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MenuIcon(
    color: Color,
    name: String,
    iconVector: ImageVector,
    onClicked: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onClicked() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 12.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(color.copy(.6f), color)
                    ),
                    shape = CircleShape
                )
                .border(2.dp, color.copy(.8f), CircleShape)
                .padding(8.dp)
                .wrapContentSize()
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = iconVector,
                contentDescription = "Close",
                tint = Color.White
            )
        }
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium
        )
    }
}