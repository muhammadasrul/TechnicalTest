package com.asrul.technicaltest.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asrul.technicaltest.util.shimmer

@Composable
fun TransactionSkeleton(
    size: Int = 3
) {
    Column {
        for (i in 1..size) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .width(152.dp)
                    .height(32.dp)
                    .shimmer(Gray.copy(.1f))
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .fillMaxWidth()
                    .height(152.dp)
                    .shimmer(Gray.copy(.1f))
            )
        }
    }
}

@Preview
@Composable
fun HistorySkeletonPreview() {
    TransactionSkeleton()
}