package com.asrul.technicaltest.ui.screen.promo

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.asrul.technicaltest.domain.model.Promo
import com.asrul.technicaltest.domain.model.toPromoDTO

const val promoListRoute = "promo_list_route"
const val promoDetailRoute = "promo_detail_route"

private const val PROMO_ARGS = "promo_args"

fun NavController.navigateToPromoList() {
    navigate(promoListRoute)
}

fun NavController.navigateToPromoDetail(promoJsonString: String) {
    navigate("$promoDetailRoute/$promoJsonString")
}

fun NavGraphBuilder.promoListScreen(
    onBackPressed: () -> Unit,
    onClicked: (Promo) -> Unit
) {
    composable(promoListRoute) {
        val viewModel = hiltViewModel<PromoViewModel>()
        val state = viewModel.state.collectAsState()

        PromoListScreen(
            state = state.value,
            onBackPressed = onBackPressed,
            onClicked = onClicked
        )
    }
}

fun NavGraphBuilder.promoDetailScreen(
    onBackPressed: () -> Unit
) {
    composable(
        route = "$promoDetailRoute/{$PROMO_ARGS}",
        arguments = listOf(
            navArgument(
                name = PROMO_ARGS,
                builder = {
                    type = NavType.StringType
                }
            )
        )
    ) {
        val promoString = it.arguments?.getString(PROMO_ARGS)
        val promo = promoString?.toPromoDTO() ?: Promo(desc = "-", img = "-", nama = "-")

        PromoDetailScreen(promo = promo) {
            onBackPressed()
        }
    }
}