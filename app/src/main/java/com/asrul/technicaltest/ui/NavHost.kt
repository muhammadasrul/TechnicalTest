package com.asrul.technicaltest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.asrul.technicaltest.ui.screen.history.navigateToTransactionHistory
import com.asrul.technicaltest.ui.screen.history.transactionHistoryScreen
import com.asrul.technicaltest.ui.screen.home.homeNavigationRoute
import com.asrul.technicaltest.ui.screen.home.homeScreen
import com.asrul.technicaltest.ui.screen.home.navigateToHome
import com.asrul.technicaltest.ui.screen.qrscanner.navigateToReceipt
import com.asrul.technicaltest.ui.screen.qrscanner.navigateToQrScanner
import com.asrul.technicaltest.ui.screen.qrscanner.qrResultNavigationRoute
import com.asrul.technicaltest.ui.screen.qrscanner.receiptScreen
import com.asrul.technicaltest.ui.screen.qrscanner.qrScannerScreen
import com.google.gson.Gson

@Composable
fun NavGraph(
    finishAffinity: () -> Unit,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = homeNavigationRoute
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        homeScreen(
            goToHistory = navHostController::navigateToTransactionHistory,
            goToQrScanner = navHostController::navigateToQrScanner,
            finishAffinity = finishAffinity
        )
        transactionHistoryScreen {
            navHostController.navigateUp()
        }
        qrScannerScreen(
            onCloseClicked = navHostController::navigateUp,
            onQrScanned = { result ->
                val jsonString = Gson().toJson(result.toTransaction())
                navHostController.navigateToReceipt(jsonString)
            }
        )
        receiptScreen {
            navHostController.navigateToHome(
                navOptions { popUpTo(qrResultNavigationRoute) }
            )
        }
    }
}