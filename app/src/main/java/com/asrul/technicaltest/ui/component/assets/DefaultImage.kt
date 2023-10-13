package com.asrul.technicaltest.ui.component.assets

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var vector: ImageVector? = null

val DefaultImage: ImageVector
    get() {
        if (vector != null) {
            return vector!!
        }
        vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 72.dp,
            defaultHeight = 72.dp,
            viewportWidth = 72f,
            viewportHeight = 72f
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
                    moveTo(63f, 17.1f)
                    verticalLineTo(40.17f)
                    curveTo(62.61f, 41.49f, 61.92f, 42.69f, 60.93f, 43.68f)
                    lineTo(43.71f, 60.9f)
                    curveTo(42.72f, 61.89f, 41.52f, 62.61f, 40.2f, 62.97f)
                    horizontalLineTo(17.1f)
                    curveTo(12.66f, 62.97f, 9f, 59.31f, 9f, 54.87f)
                    verticalLineTo(17.07f)
                    curveTo(9f, 12.6f, 12.66f, 8.97f, 17.1f, 8.97f)
                    horizontalLineTo(54.9f)
                    curveTo(59.34f, 8.97f, 63f, 12.6f, 63f, 17.07f)
                    verticalLineTo(17.1f)
                    close()
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
                    moveTo(21.78f, 25.74f)
                    curveTo(21.78f, 28.59f, 24.09f, 30.8701f, 26.91f, 30.8701f)
                    curveTo(29.73f, 30.8701f, 32.04f, 28.59f, 32.04f, 25.74f)
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
                    moveTo(38.49f, 25.74f)
                    curveTo(38.49f, 28.59f, 40.7701f, 30.8701f, 43.6201f, 30.8701f)
                    curveTo(46.4701f, 30.8701f, 48.75f, 28.59f, 48.75f, 25.74f)
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
                    moveTo(63f, 40.17f)
                    curveTo(62.61f, 41.49f, 61.92f, 42.69f, 60.93f, 43.68f)
                    lineTo(43.71f, 60.9f)
                    curveTo(42.72f, 61.89f, 41.52f, 62.61f, 40.2f, 62.97f)
                    curveTo(37.83f, 60.15f, 36.39f, 56.52f, 36.39f, 52.56f)
                    curveTo(36.39f, 52.44f, 36.39f, 52.38f, 36.39f, 52.26f)
                    curveTo(36.39f, 48.87f, 37.53f, 45.69f, 39.39f, 43.14f)
                    curveTo(42.33f, 39.03f, 47.13f, 36.36f, 52.56f, 36.36f)
                    curveTo(56.52f, 36.36f, 60.18f, 37.8f, 62.97f, 40.17f)
                    horizontalLineTo(63f)
                    close()
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
                    moveTo(39.39f, 43.14f)
                    curveTo(37.53f, 45.72f, 36.42f, 48.87f, 36.39f, 52.26f)
                    curveTo(34.98f, 52.41f, 33.57f, 52.32f, 32.22f, 51.93f)
                    curveTo(28.02f, 50.79f, 24.66f, 47.34f, 23.28f, 42.84f)
                    curveTo(23.13f, 42.45f, 23.43f, 42f, 23.85f, 42f)
                    curveTo(28.95f, 43.23f, 34.2f, 43.59f, 39.36f, 43.14f)
                    horizontalLineTo(39.39f)
                    close()
                }
            }
        }.build()
        return vector!!
    }

