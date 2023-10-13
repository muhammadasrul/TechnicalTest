package com.asrul.technicaltest.ui.screen.portfolio

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.asrul.technicaltest.data.local.model.Transaction
import com.asrul.technicaltest.data.local.model.toTransactionDTO

const val portfolioRoute = "portfolio_route"
const val portfolioDetailRoute = "portfolio_detail_route"

const val PORTFOLIO_ARGS = "portfolio_args"

fun NavHostController.navigateToPortfolio() {
    navigate(portfolioRoute)
}

fun NavHostController.navigateToPortfolioDetail(jsonString: String) {
    navigate("$portfolioDetailRoute/$jsonString")
}

fun NavGraphBuilder.portfolioScreen(
    goToDetailPortfolio: (Transaction) -> Unit,
    onBackPressed: () -> Unit
) {
    composable(portfolioRoute) {
        val viewModel = hiltViewModel<PortfolioViewModel>()
        val state = viewModel.state.collectAsState()

        PortfolioScreen(state = state.value, goToDetailPortfolio = goToDetailPortfolio) {
            onBackPressed()
        }
    }
}

fun NavGraphBuilder.portfolioDetailScreen(
    onBackPressed: () -> Unit
) {
    composable(
        route = "$portfolioDetailRoute/{${PORTFOLIO_ARGS}}",
        arguments = listOf(
            navArgument(
                name = PORTFOLIO_ARGS,
                builder = {
                    type = NavType.StringType
                }
            )
        )
    ) {
        val jsonString = it.arguments?.getString(PORTFOLIO_ARGS)
        val transaction = jsonString?.toTransactionDTO() ?: Transaction(
            detailList = listOf(),
            label = "",
            percentage = ""
        )
        PortfolioDetailScreen(transaction) {
            onBackPressed()
        }
    }
}