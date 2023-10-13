package com.asrul.technicaltest.ui.component.assets

import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var vector: ImageVector? = null

val DiscountIcon: ImageVector
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
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(14.1237f, 2.87539f)
                lineTo(14.8547f, 3.60639f)
                curveTo(15.1377f, 3.8874f, 15.5157f, 4.0434f, 15.9177f, 4.0434f)
                horizontalLineTo(16.9457f)
                curveTo(18.6067f, 4.0434f, 19.9577f, 5.3944f, 19.9577f, 7.0554f)
                verticalLineTo(8.08239f)
                curveTo(19.9577f, 8.4834f, 20.1137f, 8.8624f, 20.3967f, 9.1474f)
                lineTo(21.1147f, 9.86639f)
                curveTo(21.6837f, 10.4314f, 21.9997f, 11.1864f, 22.0027f, 11.9914f)
                curveTo(22.0057f, 12.7964f, 21.6947f, 13.5534f, 21.1277f, 14.1244f)
                lineTo(20.3947f, 14.8554f)
                curveTo(20.1137f, 15.1384f, 19.9577f, 15.5154f, 19.9577f, 15.9174f)
                verticalLineTo(16.9464f)
                curveTo(19.9577f, 18.6064f, 18.6067f, 19.9574f, 16.9467f, 19.9574f)
                horizontalLineTo(15.9157f)
                curveTo(15.5197f, 19.9574f, 15.1327f, 20.1174f, 14.8517f, 20.3964f)
                lineTo(14.1337f, 21.1144f)
                curveTo(13.5467f, 21.7054f, 12.7727f, 22.0014f, 11.9987f, 22.0014f)
                curveTo(11.2317f, 22.0014f, 10.4647f, 21.7114f, 9.8777f, 21.1294f)
                curveTo(9.8697f, 21.1214f, 9.8617f, 21.1134f, 9.8537f, 21.1044f)
                lineTo(9.14372f, 20.3954f)
                curveTo(8.8607f, 20.1144f, 8.4827f, 19.9584f, 8.0807f, 19.9574f)
                horizontalLineTo(7.05472f)
                curveTo(5.3937f, 19.9574f, 4.0437f, 18.6064f, 4.0437f, 16.9464f)
                verticalLineTo(15.9154f)
                curveTo(4.0437f, 15.5134f, 3.8867f, 15.1364f, 3.6047f, 14.8524f)
                lineTo(2.88572f, 14.1344f)
                curveTo(1.7177f, 12.9724f, 1.7037f, 11.0804f, 2.8507f, 9.9004f)
                lineTo(2.87772f, 9.87339f)
                lineTo(3.60572f, 9.14339f)
                curveTo(3.8867f, 8.8604f, 4.0437f, 8.4814f, 4.0437f, 8.0804f)
                verticalLineTo(7.05539f)
                curveTo(4.0437f, 5.3954f, 5.3937f, 4.0444f, 7.0537f, 4.0434f)
                horizontalLineTo(8.08372f)
                curveTo(8.4847f, 4.0434f, 8.8627f, 3.8864f, 9.1497f, 3.6034f)
                lineTo(9.86472f, 2.88639f)
                curveTo(11.0337f, 1.7094f, 12.9447f, 1.7034f, 14.1237f, 2.8754f)
                close()
                moveTo(10.9277f, 3.94539f)
                lineTo(10.2087f, 4.66639f)
                curveTo(9.6347f, 5.2334f, 8.8817f, 5.5434f, 8.0837f, 5.5434f)
                horizontalLineTo(7.05472f)
                curveTo(6.2217f, 5.5444f, 5.5437f, 6.2224f, 5.5437f, 7.0554f)
                verticalLineTo(8.08039f)
                curveTo(5.5437f, 8.8814f, 5.2327f, 9.6344f, 4.6687f, 10.2024f)
                lineTo(3.95872f, 10.9134f)
                curveTo(3.9517f, 10.9214f, 3.9447f, 10.9274f, 3.9377f, 10.9344f)
                curveTo(3.3507f, 11.5254f, 3.3537f, 12.4844f, 3.9447f, 13.0714f)
                lineTo(4.66672f, 13.7934f)
                curveTo(5.2327f, 14.3614f, 5.5437f, 15.1144f, 5.5437f, 15.9154f)
                verticalLineTo(16.9464f)
                curveTo(5.5437f, 17.7794f, 6.2207f, 18.4574f, 7.0547f, 18.4574f)
                horizontalLineTo(8.08172f)
                curveTo(8.8837f, 18.4584f, 9.6367f, 18.7694f, 10.2037f, 19.3344f)
                lineTo(10.9247f, 20.0534f)
                lineTo(10.9447f, 20.0754f)
                curveTo(11.5347f, 20.6514f, 12.4847f, 20.6444f, 13.0707f, 20.0554f)
                lineTo(13.7927f, 19.3354f)
                curveTo(14.3527f, 18.7764f, 15.1267f, 18.4574f, 15.9157f, 18.4574f)
                horizontalLineTo(16.9457f)
                curveTo(17.7797f, 18.4574f, 18.4577f, 17.7794f, 18.4577f, 16.9464f)
                verticalLineTo(15.9174f)
                curveTo(18.4577f, 15.1164f, 18.7677f, 14.3634f, 19.3337f, 13.7964f)
                lineTo(20.0537f, 13.0754f)
                curveTo(20.3467f, 12.7814f, 20.5037f, 12.4004f, 20.5027f, 11.9964f)
                curveTo(20.5017f, 11.5934f, 20.3427f, 11.2144f, 20.0557f, 10.9284f)
                lineTo(19.3347f, 10.2064f)
                curveTo(18.7677f, 9.6354f, 18.4577f, 8.8834f, 18.4577f, 8.0824f)
                verticalLineTo(7.05539f)
                curveTo(18.4577f, 6.2214f, 17.7797f, 5.5434f, 16.9457f, 5.5434f)
                horizontalLineTo(15.9177f)
                curveTo(15.1167f, 5.5434f, 14.3637f, 5.2324f, 13.7967f, 4.6694f)
                lineTo(13.0747f, 3.94639f)
                curveTo(12.4737f, 3.3514f, 11.5147f, 3.3544f, 10.9277f, 3.9454f)
                close()
                moveTo(14.5033f, 13.4991f)
                curveTo(15.0563f, 13.4991f, 15.5033f, 13.9461f, 15.5033f, 14.4991f)
                curveTo(15.5033f, 15.0521f, 15.0563f, 15.4991f, 14.5033f, 15.4991f)
                curveTo(13.9503f, 15.4991f, 13.4983f, 15.0521f, 13.4983f, 14.4991f)
                curveTo(13.4983f, 13.9461f, 13.9413f, 13.4991f, 14.4943f, 13.4991f)
                horizontalLineTo(14.5033f)
                close()
                moveTo(15.1011f, 8.90039f)
                curveTo(15.3941f, 9.1934f, 15.3941f, 9.6684f, 15.1011f, 9.9614f)
                lineTo(9.96012f, 15.1014f)
                curveTo(9.8141f, 15.2484f, 9.6221f, 15.3214f, 9.4301f, 15.3214f)
                curveTo(9.2381f, 15.3214f, 9.0461f, 15.2484f, 8.9001f, 15.1014f)
                curveTo(8.6071f, 14.8084f, 8.6071f, 14.3344f, 8.9001f, 14.0414f)
                lineTo(14.0401f, 8.90039f)
                curveTo(14.3331f, 8.6074f, 14.8081f, 8.6074f, 15.1011f, 8.9004f)
                close()
                moveTo(9.50332f, 8.49909f)
                curveTo(10.0563f, 8.4991f, 10.5033f, 8.9461f, 10.5033f, 9.4991f)
                curveTo(10.5033f, 10.0521f, 10.0563f, 10.4991f, 9.5033f, 10.4991f)
                curveTo(8.9503f, 10.4991f, 8.4983f, 10.0521f, 8.4983f, 9.4991f)
                curveTo(8.4983f, 8.9461f, 8.9413f, 8.4991f, 9.4943f, 8.4991f)
                horizontalLineTo(9.50332f)
                close()
            }
        }.build()
        return vector!!
    }

