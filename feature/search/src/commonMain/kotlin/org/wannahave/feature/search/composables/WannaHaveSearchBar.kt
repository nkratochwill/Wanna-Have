@file:OptIn(ExperimentalMaterial3Api::class)

package org.wannahave.feature.search.composables

import String
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import getPlatform
import org.wannahave.core.designsystem.component.LocalWannaHaveScaffoldPaddingValues

@Composable
fun WannaHaveSearchBar() {
    var searchBarQuery by rememberSaveable { mutableStateOf(String()) }
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    // Needed for correct padding in Portrait Mode
    val searchBarPadding by animateDpAsState(targetValue = if (isExpanded) 0.dp else 16.dp)
    val localFocusManager = LocalFocusManager.current
    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = searchBarQuery,
                onQueryChange = { searchBarQuery = it },
                expanded = isExpanded,
                onExpandedChange = { isExpanded = it },
                onSearch = { localFocusManager.clearFocus() }, modifier = Modifier.size(56.dp),
                placeholder = {
                    Text(
                        text = "Running from ${getPlatform().name}",
                        textAlign = TextAlign.Center
                    )
                },
                leadingIcon = {
                    if (isExpanded) {
                        IconButton(
                            onClick = { isExpanded = false }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    } else {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = searchBarQuery.isEmpty(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(imageVector = Icons.Default.Mic, contentDescription = null)
                        }
                    }
                    AnimatedVisibility(
                        visible = searchBarQuery.isNotEmpty(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(
                            onClick = { searchBarQuery = String() }
                        ) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = null)
                        }
                    }
                },
                //Shouldn't exist, Material 3 Navigationrail/Searchbar/Navigationbar is wrongly colored, it should be all the same containercolor
                colors = TextFieldDefaults.colors(focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer, unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer)
           )
        },
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
        modifier = Modifier.fillMaxWidth().padding(horizontal = searchBarPadding)
            .padding(top = searchBarPadding / 2),
        //Shouldn't exist, Material 3 Navigationrail/Searchbar/Navigationbar is wrongly colored, it should be all the same containercolor
        colors = SearchBarDefaults.colors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(LocalWannaHaveScaffoldPaddingValues.current)
        ) {
            repeat(100) {
                item { Text("test") }
            }
            item { Text("testdd") }
        }
    }
}