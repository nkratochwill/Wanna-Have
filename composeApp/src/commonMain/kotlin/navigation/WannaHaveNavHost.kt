package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.wannahave.feature.profile.navigation.profileScreen
import org.wannahave.feature.search.navigation.SEARCH_ROUTE
import org.wannahave.feature.search.navigation.searchScreen
import org.wannahave.feature.sell.navigation.sellScreen

@Composable
fun WannaHaveNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SEARCH_ROUTE
    )
    {
        searchScreen()
        sellScreen()
        profileScreen()
    }
}