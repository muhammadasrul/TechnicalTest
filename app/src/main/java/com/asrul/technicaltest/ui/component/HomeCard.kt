package com.asrul.technicaltest.ui.component

import com.asrul.technicaltest.ui.component.assets.AccountCardBackground
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asrul.technicaltest.ui.theme.AppBlue
import com.asrul.technicaltest.util.CurveShape
import com.asrul.technicaltest.util.toRupiahFormat

@Composable
fun HomeCard(
    name: String,
    currentBalance: Double,
    usedInAMonth: Double
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(CurveShape())
    ) {
        Box(
            modifier = Modifier
                .padding(top = 32.dp, start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .border(
                    1.5.dp, AppBlue.copy(.15f),
                    RoundedCornerShape(
                        topEndPercent = 10,
                        topStartPercent = 10
                    )
                )
                .clip(
                    RoundedCornerShape(
                        topEndPercent = 10,
                        topStartPercent = 10
                    )
                )
                .wrapContentHeight()
        ) {
            Image(
                modifier = Modifier
                    .height(230.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                imageVector = AccountCardBackground,
                contentDescription = "Card"
            )
            Column(
                modifier = Modifier.height(230.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(18.dp),
                    text = name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(.8f)
                )

                Row(
                    modifier = Modifier.padding(start = 18.dp, end = 18.dp, bottom = 18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .border(.5.dp, AppBlue.copy(.3f), CircleShape)
                            .background(AppBlue.copy(.1f), CircleShape)
                            .padding(6.dp)
                            .wrapContentSize()
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Check",
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier.padding(horizontal = 18.dp),
                        text = currentBalance.toRupiahFormat(),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = AppBlue,
                            RoundedCornerShape(
                                topEndPercent = 30,
                                topStartPercent = 30
                            )
                        )
                        .border(
                            width = 1.5.dp,
                            Color.White.copy(.2f),
                            RoundedCornerShape(
                                topEndPercent = 30,
                                topStartPercent = 30
                            )
                        )
                        .height(80.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "${usedInAMonth.toRupiahFormat()} udah dipake di Agustus",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}