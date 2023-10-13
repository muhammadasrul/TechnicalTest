package com.asrul.technicaltest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asrul.technicaltest.ui.theme.AppBlue
import com.asrul.technicaltest.ui.theme.AppBlueDark

enum class ButtonSize {
    SMALL, LARGE
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonSize: ButtonSize = ButtonSize.SMALL,
    action: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(listOf(AppBlue, AppBlueDark)),
                shape = RoundedCornerShape(50)
            )
            .clip(RoundedCornerShape(50))
            .clickable { action() }
            .then(
                when(buttonSize) {
                    ButtonSize.SMALL -> Modifier.padding(vertical = 6.dp, horizontal = 10.dp)
                    ButtonSize.LARGE -> Modifier.padding(vertical = 10.dp, horizontal = 24.dp)
                }
            )
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = text,
            style = MaterialTheme.typography.headlineSmall,
            color = White
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(text = "Transaction") {

    }
}