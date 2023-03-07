@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jdvila.dogceo.core.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jdvila.dogceo.core.presentation.ui.theme.DarkGray

@Composable
fun SingleTextTile(text: String, onClick: () -> Unit) {
    Card(onClick = onClick,
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
    ) {
        Text(text[0].toString().uppercase()+text.substring(1),
            color = DarkGray,
            fontSize = 22.sp,
            modifier = Modifier.padding(12.dp)
        )
    }
}