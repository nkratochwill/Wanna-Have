@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.wannahave.core.designsystem.theme.WannaHaveTheme

@Composable
@Preview
fun App() {
    val windowSize = calculateWindowSizeClass()
    val compactWindow = windowSize.widthSizeClass == WindowWidthSizeClass.Compact ||
            windowSize.widthSizeClass == WindowWidthSizeClass.Medium
    val expandedWindow = windowSize.widthSizeClass == WindowWidthSizeClass.Expanded
    WannaHaveTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = { WannaHaveSearchBar() },
                bottomBar = {
                    AnimatedVisibility(
                        visible = compactWindow,
                        enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
                        exit = fadeOut() + slideOutVertically(targetOffsetY = { it }),
                    ) {
                        WannaHaveBottomBar()
                    }
                }) {
                AnimatedVisibility(
                    visible = expandedWindow,
                    enter = fadeIn() + slideInHorizontally(),
                    exit = fadeOut() + slideOutHorizontally(),
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        WannaHaveNavigationRail()
                    }
                }
            }
        }
    }
}

@Composable
fun WannaHaveBottomBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = null) })
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Add, contentDescription = null) })
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Person, contentDescription = null) })
    }
}

@Composable
fun WannaHaveNavigationRail() {
    NavigationRail {
        NavigationRailItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = null) })
        NavigationRailItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Add, contentDescription = null) })
        NavigationRailItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Person, contentDescription = null) })
    }
}

@Composable
fun WannaHaveSearchBar() {
    var searchBarQuery by rememberSaveable { mutableStateOf(String()) }
    var isActive by rememberSaveable { mutableStateOf(false) }
    // Needed for correct padding in Portrait Mode
    val searchBarPadding by animateDpAsState(targetValue = if (isActive) 0.dp else 16.dp)
    SearchBar(
        query = searchBarQuery,
        onQueryChange = { searchBarQuery = it },
        onSearch = {},
        active = isActive,
        onActiveChange = { isActive = it },
        modifier = Modifier.fillMaxWidth().padding(searchBarPadding),
        placeholder = {
            Text(
                text = "Running from ${getPlatform().name}",
                textAlign = TextAlign.Center
            )
        },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        trailingIcon = {
            if (isActive) {
                IconButton(onClick = {
                    isActive = false
                    searchBarQuery = String()
                }) { Icon(Icons.Default.Close, contentDescription = null) }
            }
        }
    ) {

    }
}