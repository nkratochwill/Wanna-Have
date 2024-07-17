@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import navigation.WannaHaveNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.wannahave.core.designsystem.component.WannaHaveBottomBar
import org.wannahave.core.designsystem.component.WannaHaveNavigationRail
import org.wannahave.core.designsystem.theme.WannaHaveTheme
import org.wannahave.feature.profile.navigation.navigateToProfileScreen
import org.wannahave.feature.search.navigation.navigateToSearchScreen
import org.wannahave.feature.sell.navigation.navigateToSellScreen

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    val windowSize = calculateWindowSizeClass()
    val compactWindow = windowSize.widthSizeClass == WindowWidthSizeClass.Compact ||
            windowSize.widthSizeClass == WindowWidthSizeClass.Medium
    val expandedWindow = windowSize.widthSizeClass == WindowWidthSizeClass.Expanded

    WannaHaveTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = { },
                bottomBar = {
                    AnimatedVisibility(
                        visible = compactWindow,
                        enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
                        exit = fadeOut() + slideOutVertically(targetOffsetY = { it }),
                    ) {
                        WannaHaveBottomBar(
                            onSearchClick = { navController.navigateToSearchScreen() },
                            onSellClick = { navController.navigateToSellScreen() },
                            onProfileClick = { navController.navigateToProfileScreen() }
                        )
                    }
                }
            ) {
                Row {
                    AnimatedVisibility(
                        visible = expandedWindow,
                        enter = fadeIn() + slideInHorizontally(),
                        exit = fadeOut() + slideOutHorizontally(),
                    ) {
                        Box {
                            WannaHaveNavigationRail(
                                onSearchClick = { navController.navigateToSearchScreen() },
                                onSellClick = { navController.navigateToSellScreen() },
                                onProfileClick = { navController.navigateToProfileScreen() }
                            )
                        }
                    }
                    WannaHaveNavHost(navController)
                }
            }
        }
    }
}
