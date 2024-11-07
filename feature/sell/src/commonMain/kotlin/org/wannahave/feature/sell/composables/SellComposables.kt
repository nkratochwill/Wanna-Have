package org.wannahave.feature.sell.composables

import String
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.wannahave.core.designsystem.component.moveFocusOnTab

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
        modifier = Modifier.fillMaxWidth()
            //.padding(LocalWannaHaveScaffoldPaddingValues.current)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Whatcha wanna sell?", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            IconButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth().requiredWidthIn(max = 1024.dp)
            ) { Icon(imageVector = Icons.Default.Camera, contentDescription = null, modifier = Modifier.size(128.dp)) }
            OutlinedTextField(
                value = titleTextValue,
                onValueChange = { titleTextValue = it },
                modifier = Modifier.fillMaxWidth().requiredWidthIn(max = 1024.dp),
                label = { Text(text = "Title") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = descriptionTextValue,
                onValueChange = { descriptionTextValue = it },
                modifier = Modifier.fillMaxWidth().requiredWidthIn(max = 1024.dp).moveFocusOnTab(),
                label = { Text(text = "Description") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                minLines = 5
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth().requiredWidthIn(max = 1024.dp)
            ) { Text(text = "Save as draft") }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().requiredWidthIn(max = 1024.dp)
            ) { Text(text = "Summary") }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}