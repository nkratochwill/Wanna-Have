package navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val START_ROUTE = "start_route"

fun NavController.navigateToStartScreen() {
    this.navigate(route = START_ROUTE) {
        launchSingleTop = true
        popUpTo(route = this@navigateToStartScreen.graph.findStartDestination().route.orEmpty()) {
            saveState = false
        }
    }
}
fun NavGraphBuilder.startScreen(onStart:() -> Unit){
    composable(route = START_ROUTE){
        Box(modifier = Modifier.fillMaxSize()){
            Button(onClick = onStart){
                Text(text = "Start Wanna Have")
            }
        }
    }
}