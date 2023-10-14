package com.asrul.technicaltest.ui.screen.pushnotif

import android.content.Intent
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink

const val pushNotificationRoute = "push_notification_route"
const val TITLE_ARGS = "title"
const val TRANSACTION_CODE_ARGS = "transactionCode"

fun NavHostController.navigateToNotificationDetail(title: String, transactionCode: String) {
    navigate("$pushNotificationRoute/$title/$transactionCode")
}

fun NavGraphBuilder.pushNotificationDetail(
    onBackPressed: () -> Unit
) {
    composable(
        "$pushNotificationRoute/{$TITLE_ARGS}/{$TRANSACTION_CODE_ARGS}",
        deepLinks = listOf(navDeepLink {
            uriPattern = "http://sample.id/transfer/result?title={$TITLE_ARGS}&transactionCode={$TRANSACTION_CODE_ARGS}"
            action = Intent.ACTION_VIEW
        })
    ) {
        val title = it.arguments?.getString(TITLE_ARGS).orEmpty().ifEmpty { "-" }
        val transactionCode = it.arguments?.getString(TRANSACTION_CODE_ARGS).orEmpty().ifEmpty { "-" }
        PushNotificationScreen(title = title, transactionCode = transactionCode, onBackPressed = onBackPressed)
    }
}