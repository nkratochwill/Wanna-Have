package org.wannahave.core.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable

@Composable
fun WannaHaveNavigationRail(onSearchClick: ()-> Unit, onSellClick: ()-> Unit, onProfileClick: ()-> Unit) {
    NavigationRail {
        NavigationRailItem(
            selected = true,
            onClick = onSearchClick,
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
        )
        NavigationRailItem(
            selected = false,
            onClick = onSellClick,
            icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
        )
        NavigationRailItem(
            selected = false,
            onClick = onProfileClick,
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }
        )
    }
}