package com.asrul.technicaltest.ui.screen.qrscanner

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.domain.model.Transaction
import com.google.gson.Gson

const val QR_RESULT_ARGS = "qr_result"

const val qrScannerNavigationRoute = "qr_scanner_route"
const val qrResultNavigationRoute = "qr_result_route"

fun NavController.navigateToQrScanner() {
    navigate(qrScannerNavigationRoute)
}

fun NavController.navigateToReceipt(qrResultString: String) {
    navigate("$qrResultNavigationRoute/$qrResultString")
}

fun NavGraphBuilder.qrScannerScreen(
    onCloseClicked: () -> Unit,
    onQrScanned: (TransactionEntity) -> Unit
) {
    composable(qrScannerNavigationRoute) {
        val viewModel = hiltViewModel<QrScannerViewModel>()
        val state = viewModel.state.collectAsState().value

        state.data?.let { onQrScanned(it) }

        QrScannerScreen(
            onCloseClicked = onCloseClicked,
            transactionState = state,
            onQrScanned = {
                viewModel.insertTransaction(it)
            },
            onHandled = {
                viewModel.onHandled()
            }
        )
    }
}

fun NavGraphBuilder.receiptScreen(
    navigateUp: () -> Unit,
) {
    composable(
        "$qrResultNavigationRoute/{$QR_RESULT_ARGS}",
        arguments = listOf(navArgument(
            name = QR_RESULT_ARGS,
            builder = {
                type = NavType.StringType
            }
        ))
    ) {
        val qrResultString = it.arguments?.getString(QR_RESULT_ARGS)
        val transaction = Gson().fromJson(qrResultString, Transaction::class.java)

        val viewModel = hiltViewModel<QrScannerViewModel>()
        val state = viewModel.state.collectAsState()
        val userState = viewModel.userState.collectAsState()

        ReceiptScreen(
            transaction = transaction,
            navigateUp = navigateUp,
            state = state.value,
            userState = userState.value,
        )
    }
}