package com.asrul.technicaltest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.asrul.technicaltest.data.local.model.toJsonString
import com.asrul.technicaltest.domain.model.toJsonString
import com.asrul.technicaltest.ui.screen.portfolio.navigateToPortfolio
import com.asrul.technicaltest.ui.screen.portfolio.navigateToPortfolioDetail
import com.asrul.technicaltest.ui.screen.portfolio.portfolioDetailScreen
import com.asrul.technicaltest.ui.screen.portfolio.portfolioScreen
import com.asrul.technicaltest.ui.screen.history.navigateToTransactionHistory
import com.asrul.technicaltest.ui.screen.history.transactionHistoryScreen
import com.asrul.technicaltest.ui.screen.home.homeNavigationRoute
import com.asrul.technicaltest.ui.screen.home.homeScreen
import com.asrul.technicaltest.ui.screen.home.navigateToHome
import com.asrul.technicaltest.ui.screen.promo.navigateToPromoDetail
import com.asrul.technicaltest.ui.screen.promo.navigateToPromoList
import com.asrul.technicaltest.ui.screen.promo.promoDetailScreen
import com.asrul.technicaltest.ui.screen.promo.promoListScreen
import com.asrul.technicaltest.ui.screen.pushnotif.navigateToNotificationDetail
import com.asrul.technicaltest.ui.screen.pushnotif.pushNotificationDetail
import com.asrul.technicaltest.ui.screen.qrscanner.navigateToQrScanner
import com.asrul.technicaltest.ui.screen.qrscanner.navigateToReceipt
import com.asrul.technicaltest.ui.screen.qrscanner.qrResultNavigationRoute
import com.asrul.technicaltest.ui.screen.qrscanner.qrScannerScreen
import com.asrul.technicaltest.ui.screen.qrscanner.receiptScreen
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
            goToPromo = navHostController::navigateToPromoList,
            goToPortfolio = navHostController::navigateToPortfolio,
            goToNotification = {
                navHostController.navigateToNotificationDetail(
                    title = "habitasse",
                    transactionCode = "mutat"
                )
            },
            finishAffinity = finishAffinity
        )
        transactionHistoryScreen(navHostController::navigateUp)
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
        promoListScreen(
            onBackPressed = navHostController::navigateUp,
            onClicked = { promo ->
                navHostController.navigateToPromoDetail(promo.toJsonString())
            }
        )
        promoDetailScreen(navHostController::navigateUp)
        portfolioScreen(
            goToDetailPortfolio = {
                navHostController.navigateToPortfolioDetail(it.toJsonString())
            },
            onBackPressed = navHostController::navigateUp
        )
        portfolioDetailScreen(navHostController::navigateUp)
        pushNotificationDetail(navHostController::navigateUp)
    }
}