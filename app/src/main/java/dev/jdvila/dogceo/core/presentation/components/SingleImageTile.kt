@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jdvila.dogceo.core.presentation.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.jdvila.dogceo.R


@Composable
fun SingleImageTile(url: String, desc: String) {
    Card(shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 250.dp)
            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
    ) {
        AsyncImage(
            model = url,
            contentDescription = desc,
            contentScale = ContentScale.FillWidth,
            placeholder = painterResource(id = R.drawable.dog_placeholder),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}