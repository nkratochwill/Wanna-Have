package org.wannahave.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.wannahave.feature.search.composables.SearchRoute

const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearchScreen() {
    this.navigate(SEARCH_ROUTE) {
        launchSingleTop = true
    }
}
fun NavGraphBuilder.searchScreen(){
    composable(route = SEARCH_ROUTE){
        SearchRoute()
    }
}