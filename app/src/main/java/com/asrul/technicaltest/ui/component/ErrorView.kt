package com.asrul.technicaltest.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    title: String,
    message: String = "",
    textColor: Color = White,
    actionText: String = "",
    action: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            color = textColor,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = message,
            color = textColor,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium
        )
        if (actionText.isNotEmpty()) {
            Divider(thickness = 32.dp, color = Color.Transparent)
            PrimaryButton(text = actionText, buttonSize = ButtonSize.SMALL) {
                action()
            }
        }
    }
}