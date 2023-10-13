package com.asrul.technicaltest.ui.component.assets

import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var vector: ImageVector? = null

val QuestionIcon: ImageVector
    get() {
        if (vector != null) {
            return vector!!
        }
        vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            group {
                path(
                    fill = null,
                    fillAlpha = 1.0f,
                    stroke = SolidColor(Color(0xFF000000)),
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.5f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(9.35999f, 8.62999f)
                    curveTo(9.68f, 8.29f, 10.05f, 8.02f, 10.48f, 7.85f)
                    curveTo(10.9f, 7.68f, 11.37f, 7.61f, 11.83f, 7.64f)
                    curveTo(12.3f, 7.68f, 12.74f, 7.81f, 13.14f, 8.04f)
                    curveTo(13.54f, 8.27f, 13.88f, 8.6f, 14.13f, 8.98f)
                    curveTo(14.38f, 9.37f, 14.55f, 9.8f, 14.62f, 10.27f)
                    curveTo(14.67f, 10.72f, 14.64f, 11.2f, 14.49f, 11.63f)
                    curveTo(14.36f, 12.06f, 14.11f, 12.48f, 13.79f, 12.79f)
                    curveTo(13.46f, 13.12f, 13.07f, 13.37f, 12.63f, 13.53f)
                }
                path(
                    fill = null,
                    fillAlpha = 1.0f,
                    stroke = SolidColor(Color(0xFF000000)),
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.5f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(21f, 12f)
                    curveTo(21f, 7.0294f, 16.9706f, 3f, 12f, 3f)
                    curveTo(7.0294f, 3f, 3f, 7.0294f, 3f, 12f)
                    curveTo(3f, 16.9706f, 7.0294f, 21f, 12f, 21f)
                    curveTo(16.9706f, 21f, 21f, 16.9706f, 21f, 12f)
                    close()
                }
                path(
                    fill = null,
                    fillAlpha = 1.0f,
                    stroke = SolidColor(Color(0xFF000000)),
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(12f, 16.5f)
                    horizontalLineTo(12.01f)
                }
            }
        }.build()
        return vector!!
    }

