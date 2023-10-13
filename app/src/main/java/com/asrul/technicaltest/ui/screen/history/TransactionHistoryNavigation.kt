package com.asrul.technicaltest.ui.screen.history

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val transactionHistoryNavigationRoute = "transaction_history_route"

fun NavController.navigateToTransactionHistory() {
    navigate(transactionHistoryNavigationRoute)
}

fun NavGraphBuilder.transactionHistoryScreen(
    onBackPressed: () -> Unit
) {
    composable(transactionHistoryNavigationRoute) {
        val viewModel: TransactionHistoryViewModel = hiltViewModel()
        val state = viewModel.transactionState.collectAsState()
        TransactionHistoryScreen(
            state = state.value
        ) { onBackPressed() }
    }
}