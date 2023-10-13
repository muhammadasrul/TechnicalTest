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

val ChartIcon: ImageVector
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
                    moveTo(10.65f, 9.29999f)
                    curveTo(10.65f, 9.68f, 10.51f, 10.04f, 10.28f, 10.3f)
                    curveTo(10f, 10.66f, 9.57f, 10.88f, 9.07f, 10.88f)
                    curveTo(8.52f, 10.88f, 8.05f, 10.61f, 7.77f, 10.19f)
                    curveTo(7.59f, 9.94f, 7.5f, 9.63f, 7.5f, 9.31f)
                    curveTo(7.5f, 8.44f, 8.2f, 7.74f, 9.08f, 7.74f)
                    curveTo(9.96f, 7.74f, 10.65f, 8.44f, 10.65f, 9.31f)
                    verticalLineTo(9.29999f)
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
                    moveTo(16.5f, 14.7f)
                    curveTo(16.5f, 15.57f, 15.8f, 16.27f, 14.92f, 16.27f)
                    curveTo(14.04f, 16.27f, 13.35f, 15.57f, 13.35f, 14.7f)
                    curveTo(13.35f, 14.35f, 13.47f, 14.03f, 13.67f, 13.77f)
                    curveTo(13.95f, 13.38f, 14.4f, 13.13f, 14.93f, 13.13f)
                    curveTo(15.46f, 13.13f, 15.95f, 13.4f, 16.23f, 13.82f)
                    curveTo(16.41f, 14.07f, 16.5f, 14.38f, 16.5f, 14.7f)
                    verticalLineTo(14.7f)
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
                    moveTo(13.53f, 13.58f)
                    lineTo(10.41f, 10.42f)
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
                    moveTo(21f, 8.97998f)
                    lineTo(16.5f, 13.48f)
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
                    moveTo(3f, 15.01f)
                    lineTo(7.62f, 10.39f)
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
                    moveTo(17f, 3f)
                    horizontalLineTo(7f)
                    curveTo(4.7909f, 3f, 3f, 4.7909f, 3f, 7f)
                    verticalLineTo(17f)
                    curveTo(3f, 19.2091f, 4.7909f, 21f, 7f, 21f)
                    horizontalLineTo(17f)
                    curveTo(19.2091f, 21f, 21f, 19.2091f, 21f, 17f)
                    verticalLineTo(7f)
                    curveTo(21f, 4.7909f, 19.2091f, 3f, 17f, 3f)
                    close()
                }
            }
        }.build()
        return vector!!
    }

