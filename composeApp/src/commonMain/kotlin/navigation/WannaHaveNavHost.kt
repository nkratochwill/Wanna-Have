package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.wannahave.feature.search.navigation.navigateToSearchScreen

@Composable
fun WannaHaveNavHost(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = START_ROUTE)
    {
        startScreen {
            navController.navigateToSearchScreen()
        }
    }
}