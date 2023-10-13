package com.asrul.technicaltest.util

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import com.asrul.technicaltest.domain.model.QrResult
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Double.toRupiahFormat(): String {
    val symbol = DecimalFormatSymbols(Locale("id", "ID"))
    val formatter = DecimalFormat("#,##0.00", symbol)
    val result = formatter.format(this)
    return "Rp $result"
}

fun Long.toFormattedDate(): String {
    val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return sdf.format(Date(this))
}

fun String.toDateFormat(): String {
    val oldSdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val newSdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return oldSdf.parse(this)?.let { newSdf.format(it) } ?: "-"
}

fun String.toQrResultDTO(): QrResult? {
    val resultString = split(".")
    return try {
        QrResult(
            sof = resultString[0],
            transactionId = resultString[1],
            merchant = resultString[2],
            transactionAmount = resultString[3]
        )
    } catch (_: Exception) {
        null
    }
}

fun Modifier.shimmer(color: Color): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }

    val transition = rememberInfiniteTransition(label = "")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            tween(1000)
        ), label = ""
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                color,
                color.copy(alpha = .5f),
                color
            ),
            start = Offset(startOffsetX, size.height.toFloat()),
            end = Offset(startOffsetX + size.width.toFloat(), 0f)
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}