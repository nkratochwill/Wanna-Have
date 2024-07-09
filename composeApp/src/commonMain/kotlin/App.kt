@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.designsystem.theme.WannaHaveTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    WannaHaveTheme {
        Scaffold(
            topBar = { WannaHaveSearchBar() },
            bottomBar = { WannaHaveBottomBar() }) {
            Surface(modifier = Modifier.fillMaxSize()) {
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
fun WannaHaveSearchBar() {
    var query by rememberSaveable { mutableStateOf("") }
    var isActive by rememberSaveable { mutableStateOf(false) }
    // Needed for correct padding in Portrait Mode
    val searchBarPadding by animateDpAsState(targetValue = if (isActive) 0.dp else 16.dp)
    SearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = {},
        active = isActive,
        onActiveChange = { isActive = it },
        modifier = Modifier.fillMaxWidth().padding(searchBarPadding),
        placeholder = { Text(text = "Running from ${getPlatform().name}", textAlign = TextAlign.Center) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
    ) {

    }
}