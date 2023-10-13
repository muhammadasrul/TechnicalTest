package com.asrul.technicaltest.ui.component

import com.asrul.technicaltest.ui.component.assets.TransactionIcon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.asrul.technicaltest.domain.model.Transaction
import com.asrul.technicaltest.ui.theme.AppBlue
import com.asrul.technicaltest.ui.theme.AppBlueDark
import com.asrul.technicaltest.ui.theme.AppRed
import com.asrul.technicaltest.util.toRupiahFormat

@Composable
fun TransactionItemView(
    modifier: Modifier = Modifier,
    transaction: Transaction,
    isLastItem: Boolean = false
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .border(1.dp, Gray.copy(.2f), RoundedCornerShape(16.dp))
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .background(
                        brush = Brush.verticalGradient(listOf(AppBlue, AppBlueDark)),
                        shape = CircleShape
                    )
                    .padding(6.dp)
                    .wrapContentSize()
            ) {
                Icon(
                    imageVector = TransactionIcon,
                    contentDescription = "Close",
                    tint = White
                )
            }
            Text(
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 12.dp)
                    .weight(1f),
                text = transaction.merchant,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Start,
            )
            Text(
                text = "-${transaction.transactionAmount.toRupiahFormat()}",
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center,
                color = AppRed
            )
        }
        if (!isLastItem) {
            Divider(thickness = 12.dp, color = Transparent)
        }
    }
}