package org.wannahave.core.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun WannaHaveBottomBar(onSearchClick: ()-> Unit, onSellClick: ()-> Unit, onProfileClick: ()-> Unit) {
    //containerColor = MaterialTheme.colorScheme.surfaceContainerHighest Needed for same color as Searchbar
    NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainerHighest) {
        NavigationBarItem(
            selected = true,
            onClick = onSearchClick,
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = onSellClick,
            icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = onProfileClick,
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }
        )
    }
}

