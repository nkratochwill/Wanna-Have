package org.wannahave.feature.sell.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.wannahave.feature.sell.composables.SellRoute

const val SELL_ROUTE = "sell_route"

fun NavController.navigateToSellScreen() {
    if (this.currentDestination?.route !== SELL_ROUTE) {
        this.navigate(SELL_ROUTE) {
            launchSingleTop = true
        }
    }
}

fun NavGraphBuilder.sellScreen() {
    composable(route = SELL_ROUTE) {
        SellRoute()
    }
}