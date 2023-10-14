package com.asrul.technicaltest.util

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class WaveShape(
    private val waveCount: Int = 20
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                reset()
                moveTo(0f, 0f)
                val waveWidth = size.width / waveCount
                val waveHeight = 10f
                val halfWaveWidth = waveWidth / 2

                for (i in 0..size.width.toInt()-waveWidth.toInt() step waveWidth.toInt()) {
                    relativeQuadraticBezierTo(
                        halfWaveWidth / 2,
                        -waveHeight,
                        halfWaveWidth,
                        0f
                    )
                    relativeQuadraticBezierTo(
                        halfWaveWidth / 2,
                        waveHeight,
                        halfWaveWidth,
                        0f
                    )
                }
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
        )
    }
}