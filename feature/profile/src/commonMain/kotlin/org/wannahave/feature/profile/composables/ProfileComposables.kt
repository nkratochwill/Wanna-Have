@file:OptIn(ExperimentalMaterial3Api::class)

package org.wannahave.feature.profile.composables

import androidx.compose.foundation.layout.fillMaxWidth
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
                colors = TopAppBarDefaults.topAppBarColors(scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh)
            )
        }) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
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