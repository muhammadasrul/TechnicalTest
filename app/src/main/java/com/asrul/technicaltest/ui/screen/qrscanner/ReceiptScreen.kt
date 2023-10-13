package com.asrul.technicaltest.ui.screen.qrscanner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asrul.technicaltest.domain.model.Transaction
import com.asrul.technicaltest.domain.model.User
import com.asrul.technicaltest.ui.component.PrimaryButton
import com.asrul.technicaltest.ui.theme.AppBlue
import com.asrul.technicaltest.ui.theme.AppBlueDark
import com.asrul.technicaltest.util.toRupiahFormat

@Composable
internal fun ReceiptScreen(
    transaction: Transaction,
    state: InsertTransactionState,
    userState: UserState,
    navigateUp: () -> Unit
) {
    val data by remember { mutableStateOf(transaction) }
    var isHandled by remember { mutableStateOf(false) }

    if (!state.isLoading && state.isSuccess && !isHandled) {
        navigateUp()
        isHandled = true
    }
    Scaffold(
        containerColor = AppBlueDark
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(horizontal = 18.dp)
                        .background(White, RoundedCornerShape(24.dp))
                        .fillMaxWidth()
                        .height(130.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = data.merchant.ifEmpty { "⏤" },
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .background(AppBlue, CircleShape)
                            .border(.5.dp, AppBlue.copy(.3f), CircleShape)
                            .padding(18.dp),
                        imageVector = Icons.Default.Home,
                        contentDescription = "Merchant",
                        colorFilter = ColorFilter.tint(White)
                    )
                }
            }

            Box(
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(horizontal = 18.dp)
                        .background(White, WaveShape())
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Transaction ID",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = data.transactionId.ifEmpty { "⏤" },
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Divider(color = Color.Transparent, thickness = 8.dp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Merchant",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = data.merchant.ifEmpty { "⏤" },
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Divider(color = Color.Transparent, thickness = 8.dp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Transaction Anmount",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = data.transactionAmount.toRupiahFormat(),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp),
                    text = "Sisa Saldo: ${(userState.data?.currentBalance ?: 0.0).toRupiahFormat()}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = White,
                    textAlign = TextAlign.Center,
                )
                PrimaryButton(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, bottom = 32.dp)
                        .fillMaxWidth(),
                    text = "Back to Home",
                    action = { navigateUp() }
                )
            }
        }
    }
}

@Preview
@Composable
fun QrResultPreview() {
    ReceiptScreen(
        state = InsertTransactionState(
            isLoading = false,
            isSuccess = false,
            error = "aperiri"
        ),
        userState = UserState(isLoading = false, error = "", data = User(
            id = "luctus",
            currentBalance = 6000.7,
            name = "Chadwick Mathews"
        )),
        transaction = Transaction(
            transactionId = "tellus",
            merchant = "feugiat",
            transactionAmount = 10.11,
            date = "agam"
        ),
        navigateUp = {}
    )
}