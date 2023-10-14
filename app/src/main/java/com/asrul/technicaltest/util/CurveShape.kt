package com.asrul.technicaltest.util

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CurveShape: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                reset()
                moveTo(0f, 0f)
                lineTo(size.width, 0f)
                lineTo(size.width, size.height-80f)
                cubicTo(size.width-(size.width/5), size.height, size.width/5, size.height, 0f, size.height-80f)
                close()
            }
        )
    }
}