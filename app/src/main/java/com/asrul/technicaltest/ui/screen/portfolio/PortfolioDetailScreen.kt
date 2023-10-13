package com.asrul.technicaltest.ui.screen.portfolio

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.asrul.technicaltest.data.local.model.Transaction
import com.asrul.technicaltest.ui.theme.AppBlue
import com.asrul.technicaltest.ui.theme.AppBlueDark
import com.asrul.technicaltest.util.toDateFormat
import com.asrul.technicaltest.util.toRupiahFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioDetailScreen(
    transaction: Transaction,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Transaction Detail",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                navigationIcon = {
                    IconButton(onBackPressed) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Close",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Card(
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .height(152.dp)
                    .wrapContentHeight(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = AppBlue.copy(.15f))
            ) {
                Column(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .fillMaxWidth(),
                        text = transaction.label,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "${transaction.percentage}/100",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    LinearProgressIndicator(
                        modifier = Modifier
                            .padding(horizontal = 32.dp, vertical = 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .height(24.dp)
                            .fillMaxWidth(),
                        progress = if (transaction.percentage.isNotEmpty())
                            transaction.percentage.toFloat() / 100 else 0f,
                        trackColor = AppBlueDark.copy(alpha = .5f),
                        color = AppBlueDark
                    )
                }
            }
            Divider(color = Color.Transparent, thickness = 18.dp)
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 4.dp)
                    .fillMaxWidth(),
                text = "Transaction History",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineSmall
            )
            LazyColumn {
                items(transaction.detailList) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 18.dp, vertical = 8.dp)
                            .border(1.dp, Color.Gray.copy(.2f), RoundedCornerShape(16.dp))
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp)
                        ,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .weight(1f),
                            text = it.nominal.toDouble().toRupiahFormat(),
                            style = MaterialTheme.typography.labelLarge,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = it.trxDate.toDateFormat(),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}