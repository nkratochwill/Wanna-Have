package org.wannahave.feature.sell.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import String
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SellRoute() {
    SellScreen()
}

@Composable
fun SellScreen() {
    SellContent()
}

@Composable
fun SellContent() {
    var titleTextValue by rememberSaveable { mutableStateOf(String()) }
    var descriptionTextValue by rememberSaveable { mutableStateOf(String()) }
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).verticalScroll(
            rememberScrollState()
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Whatcha wanna sell?", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = titleTextValue,
            onValueChange = { titleTextValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Title") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = descriptionTextValue,
            onValueChange = { descriptionTextValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Description") },
            minLines = 5
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}