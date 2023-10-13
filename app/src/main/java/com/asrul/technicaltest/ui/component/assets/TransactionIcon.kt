package com.asrul.technicaltest.ui.component.assets

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var vector: ImageVector? = null

val TransactionIcon: ImageVector
    get() {
        if (vector != null) {
            return vector!!
        }
        vector = ImageVector.Builder(
            name = "com.asrul.technicaltest.ui.component.assets.vector",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(10.211f, 6.84875f)
                curveTo(9.8702f, 6.2046f, 8.0677f, 2.9879f, 6.0752f, 2.9879f)
                curveTo(4.0827f, 2.9879f, 2.2793f, 6.2046f, 1.9385f, 6.8487f)
                curveTo(1.7235f, 7.2554f, 1.8785f, 7.7596f, 2.2852f, 7.9754f)
                curveTo(2.6902f, 8.1879f, 3.196f, 8.0354f, 3.4118f, 7.6288f)
                curveTo(3.9035f, 6.7021f, 4.6235f, 5.7146f, 5.2418f, 5.1429f)
                verticalLineTo(14.337f)
                curveTo(5.2418f, 14.7979f, 5.6143f, 15.1704f, 6.0752f, 15.1704f)
                curveTo(6.536f, 15.1704f, 6.9085f, 14.7979f, 6.9085f, 14.337f)
                verticalLineTo(5.14291f)
                curveTo(7.5268f, 5.7154f, 8.2468f, 6.7021f, 8.7377f, 7.6288f)
                curveTo(8.8877f, 7.9104f, 9.1769f, 8.0721f, 9.4752f, 8.0721f)
                curveTo(9.6069f, 8.0721f, 9.741f, 8.0404f, 9.8644f, 7.9754f)
                curveTo(10.271f, 7.7596f, 10.426f, 7.2554f, 10.211f, 6.8487f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(18.1316f, 12.0271f)
                curveTo(17.7283f, 11.8112f, 17.2208f, 11.9662f, 17.0049f, 12.3721f)
                curveTo(16.5149f, 13.2971f, 15.7983f, 14.2821f, 15.1833f, 14.8546f)
                verticalLineTo(5.66292f)
                curveTo(15.1833f, 5.2029f, 14.8108f, 4.8296f, 14.3499f, 4.8296f)
                curveTo(13.8891f, 4.8296f, 13.5166f, 5.2029f, 13.5166f, 5.6629f)
                verticalLineTo(14.8579f)
                curveTo(12.8983f, 14.2862f, 12.1783f, 13.2996f, 11.6866f, 12.3721f)
                curveTo(11.4708f, 11.9662f, 10.9624f, 11.8104f, 10.5599f, 12.0271f)
                curveTo(10.1533f, 12.2421f, 9.9983f, 12.7454f, 10.2133f, 13.1529f)
                curveTo(10.5541f, 13.7971f, 12.3566f, 17.0121f, 14.3499f, 17.0121f)
                curveTo(16.3349f, 17.0121f, 18.1374f, 13.7971f, 18.4783f, 13.1529f)
                curveTo(18.6933f, 12.7454f, 18.5383f, 12.2421f, 18.1316f, 12.0271f)
                close()
            }
        }.build()
        return vector!!
    }

