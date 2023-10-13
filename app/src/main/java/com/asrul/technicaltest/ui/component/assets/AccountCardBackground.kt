import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var vector: ImageVector? = null

val AccountCardBackground: ImageVector
    get() {
        if (vector != null) {
            return vector!!
        }
        vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 331.dp,
            defaultHeight = 212.dp,
            viewportWidth = 331f,
            viewportHeight = 212f
        ).apply {
            group {
                path(
                    fill = Brush.linearGradient(
                        start = Offset(0f, 0f),
                        end = Offset(330.912f, 212.138f),
                        colorStops = arrayOf(
                            0f to Color(0xFF00C2FA),
                            1f to Color(0xFF0062EB),
                        ),
                    ),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(0f, 0f)
                    horizontalLineTo(331f)
                    verticalLineTo(212f)
                    horizontalLineTo(0f)
                    verticalLineTo(0f)
                    close()
                }
                group {
                    path(
                        fill = Brush.linearGradient(
                            start = Offset(262.443f, 66.3839f),
                            end = Offset(262.443f, 259.111f),
                            colorStops = arrayOf(
                                0f to Color(0xFF01FEDF),
                                1f to Color(0xFF0AF7D6),
                            ),
                        ),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.EvenOdd
                    ) {
                        moveTo(262.443f, 201.293f)
                        curveTo(283.741f, 201.293f, 301.006f, 184.036f, 301.006f, 162.747f)
                        curveTo(301.006f, 141.459f, 283.741f, 124.202f, 262.443f, 124.202f)
                        curveTo(241.146f, 124.202f, 223.88f, 141.459f, 223.88f, 162.747f)
                        curveTo(223.88f, 184.036f, 241.146f, 201.293f, 262.443f, 201.293f)
                        close()
                        moveTo(262.443f, 259.111f)
                        curveTo(315.688f, 259.111f, 358.851f, 215.968f, 358.851f, 162.747f)
                        curveTo(358.851f, 109.527f, 315.688f, 66.3839f, 262.443f, 66.3839f)
                        curveTo(209.199f, 66.3839f, 166.036f, 109.527f, 166.036f, 162.747f)
                        curveTo(166.036f, 215.968f, 209.199f, 259.111f, 262.443f, 259.111f)
                        close()
                    }
                }
                group {
                    path(
                        fill = Brush.linearGradient(
                            start = Offset(166.571f, -48.1818f),
                            end = Offset(166.571f, 66.3838f),
                            colorStops = arrayOf(
                                0f to Color(0xFFFFD03B),
                                1f to Color(0xFFFFC129),
                            ),
                        ),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.EvenOdd
                    ) {
                        moveTo(166.571f, 34.2626f)
                        curveTo(180.474f, 34.2626f, 191.744f, 22.9974f, 191.744f, 9.101f)
                        curveTo(191.744f, -4.7954f, 180.474f, -16.0606f, 166.571f, -16.0606f)
                        curveTo(152.668f, -16.0606f, 141.398f, -4.7954f, 141.398f, 9.101f)
                        curveTo(141.398f, 22.9974f, 152.668f, 34.2626f, 166.571f, 34.2626f)
                        close()
                        moveTo(166.571f, 66.3838f)
                        curveTo(198.222f, 66.3838f, 223.88f, 40.7374f, 223.88f, 9.101f)
                        curveTo(223.88f, -22.5354f, 198.222f, -48.1818f, 166.571f, -48.1818f)
                        curveTo(134.92f, -48.1818f, 109.262f, -22.5354f, 109.262f, 9.101f)
                        curveTo(109.262f, 40.7374f, 134.92f, 66.3838f, 166.571f, 66.3838f)
                        close()
                    }
                }
            }
        }.build()
        return vector!!
    }

