package org.wannahave.feature.search.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun ItemCard(item: Item) {
    var a: String? by rememberSaveable{ mutableStateOf("")}
    Column(
        modifier = Modifier.width(96.dp).height(192.dp),
    ) {
        Card(
            modifier = Modifier.width(96.dp).height(128.dp),
        ) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(item.imageUrl),
                    contentDescription = item.title,
                    modifier = Modifier.height(124.dp)
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)),
                    contentScale = ContentScale.Crop
                )
                LinearProgressIndicator(
                    progress = { item.currentProgress },
                    drawStopIndicator = { })
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = a?:item.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.basicMarquee()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "2005",
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "1h 25m",
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}