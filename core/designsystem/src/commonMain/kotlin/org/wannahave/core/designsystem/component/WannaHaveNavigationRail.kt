package org.wannahave.core.designsystem.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WannaHaveNavigationRail(onSearchClick: ()-> Unit, onSellClick: ()-> Unit, onProfileClick: ()-> Unit) {
    NavigationRail(containerColor = MaterialTheme.colorScheme.surfaceContainer) {
        Spacer(modifier = Modifier.height(16.dp))
        NavigationRailItem(
            selected = true,
            onClick = onSearchClick,
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavigationRailItem(
            selected = false,
            onClick = onSellClick,
            icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavigationRailItem(
            selected = false,
            onClick = onProfileClick,
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}