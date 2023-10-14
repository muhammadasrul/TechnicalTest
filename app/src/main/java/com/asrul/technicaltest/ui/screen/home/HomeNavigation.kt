package com.asrul.technicaltest.ui.screen.home

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    goToHistory: () -> Unit,
    goToQrScanner: () -> Unit,
    goToPromo: () -> Unit,
    goToPortfolio: () -> Unit,
    goToNotification: () -> Unit,
    finishAffinity: () -> Unit
) {
    composable(homeNavigationRoute) {
        BackHandler {
            finishAffinity()
        }

        val viewModel = hiltViewModel<HomeViewModel>()
        val transactionState = viewModel.transactionState.collectAsState()
        val userState = viewModel.userState.collectAsState()
        HomeScreen(
            transactionState = transactionState.value,
            userState = userState.value,
            goToHistory = goToHistory,
            goToQrScanner = goToQrScanner,
            goToPromo = goToPromo,
            goToPortfolio = goToPortfolio,
            goToNotification = goToNotification
        )
    }
}