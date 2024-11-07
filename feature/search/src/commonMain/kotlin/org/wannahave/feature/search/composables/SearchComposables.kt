@file:OptIn(ExperimentalMaterial3Api::class)

package org.wannahave.feature.search.composables

import String
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import getPlatform

@Composable
fun SearchRoute() {
    SearchScreen()
}

@Composable
fun SearchScreen() {
    SearchContent()
}

@Composable
fun SearchContent() {
    Column {
        WannaHaveSearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        Column(Modifier.verticalScroll(rememberScrollState())) {
            DealsSection(listOf(Deal("Deal 1", "$100", 0), Deal("Deal 2", "$200", 0)))
            DealsSection(listOf(Deal("Deal 1", "$100", 0), Deal("Deal 2", "$200", 0)))
            DealsSection(listOf(Deal("Deal 1", "$100", 0), Deal("Deal 2", "$200", 0)))
            DealsSection(listOf(Deal("Deal 1", "$100", 0), Deal("Deal 2", "$200", 0)))
            DealsSection(listOf(Deal("Deal 1", "$100", 0), Deal("Deal 2", "$200", 0)))
        }
    }
}

@Composable
fun WannaHaveSearchBar() {
    var searchBarQuery by rememberSaveable { mutableStateOf(String()) }
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    // Needed for correct padding in Portrait Mode
    val searchBarPadding by animateDpAsState(targetValue = if (isExpanded) 0.dp else 16.dp)

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = searchBarQuery,
                onQueryChange = { searchBarQuery = it },
                expanded = isExpanded,
                onExpandedChange = { isExpanded = it },
                onSearch = { },
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
            )
        },
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
        modifier = Modifier.fillMaxWidth().padding(searchBarPadding),
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) { }
    }
}
//https://hazelcast.com/blog/locksupport-parknanos-under-the-hood-and-the-curious-case-of-parking-part-ii-windows/

@Composable
fun DealsSection(deals: List<Deal>) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Deals of the Day",
                style = MaterialTheme.typography.headlineSmall
            )
            TextButton(onClick = { /* Handle "Open All" click */ }) {
                Text("Open All")
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 160.dp)
        ) {
            items(deals) { deal ->
                DealItem(deal = deal)
                DealItem(deal = deal)
                DealItem(deal = deal)
                DealItem(deal = deal)
            }
        }
    }
}

@Composable
fun DealItem(deal: Deal) {
    Card(
        modifier = Modifier
            .width(128.dp)
            .height(128.dp),
    ) {
        Column {
            Image(
                imageVector = Icons.Default.Terrain, // Replace with your image loading logic
                contentDescription = deal.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = deal.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = deal.price,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}

data class Deal(
    val title: String,
    val price: String,
    val image: Int // Replace with your image data type
)




