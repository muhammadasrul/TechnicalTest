package com.asrul.technicaltest.ui.screen.history

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asrul.technicaltest.ui.component.ErrorView
import com.asrul.technicaltest.ui.component.TransactionItem
import com.asrul.technicaltest.ui.component.TransactionSkeleton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TransactionHistoryScreen(
    state: TransactionHistoryState,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Transaction History",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                navigationIcon = {
                    IconButton(onBackPressed) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Close",
                            tint = Black
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                LazyColumn {
                    item {
                        if (state.isLoading) {
                            TransactionSkeleton(4)
                        }
                    }
                    item {
                        AnimatedVisibility(visible = !state.isLoading && state.error.isNotEmpty()) {
                            ErrorView(
                                modifier = Modifier
                                    .height(600.dp)
                                    .fillMaxSize(),
                                title = if (state.data.isEmpty()) "No Transaction" else "Oops, Sorry",
                                message = state.error,
                                textColor = Black
                            )
                        }
                    }
                    if (!state.isLoading && state.error.isEmpty()) {
                        state.data.forEach {
                            item {
                                Text(
                                    modifier = Modifier.padding(
                                        top = 20.dp,
                                        bottom = 8.dp,
                                        start = 24.dp,
                                        end = 24.dp
                                    ),
                                    text = it.key,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Black
                                )
                            }
                            itemsIndexed(items = it.value) { index, item ->
                                TransactionItem(
                                    modifier = Modifier.padding(horizontal = 14.dp),
                                    transaction = item,
                                    isLastItem = index == it.value.lastIndex
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TransactionHistoryScreenPreview() {
    TransactionHistoryScreen(state = TransactionHistoryState(error = "Error")) {}
}