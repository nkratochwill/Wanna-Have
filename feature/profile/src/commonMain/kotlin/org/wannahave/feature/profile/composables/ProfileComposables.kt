@file:OptIn(ExperimentalMaterial3Api::class)

package org.wannahave.feature.profile.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProfileRoute() {
    ProfileScreen()
}

@Composable
fun ProfileScreen() {
    ProfileContent()
}

@Composable
fun ProfileContent() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Your Account") },
                scrollBehavior = scrollBehavior,
              )
        }) {
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(it)) {
            item {
                Text(
                    "Library",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item {
                Text(
                    "Appearance",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item {
                Text(
                    "Playback",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item {
                Text(
                    "Advanced",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
            item { Text("test") }
        }
    }
}