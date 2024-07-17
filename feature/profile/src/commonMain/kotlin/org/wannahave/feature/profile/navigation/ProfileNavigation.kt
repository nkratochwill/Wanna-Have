package org.wannahave.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.wannahave.feature.profile.composables.ProfileRoute

const val PROFILE_ROUTE = "profile_route"

fun NavController.navigateToProfileScreen() {
    if (this.currentDestination?.route !== PROFILE_ROUTE) {
        this.navigate(PROFILE_ROUTE) {
            launchSingleTop = true
        }
    }
}

fun NavGraphBuilder.profileScreen() {
    composable(route = PROFILE_ROUTE) {
        ProfileRoute()
    }
}