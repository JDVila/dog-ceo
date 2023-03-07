package dev.jdvila.dogceo.core.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val lightColors = lightColorScheme(
    primary = Red700,
    onPrimary = Color.White,
    secondary = Red800,
    onSecondary = Color.White,
    error = Red900,
)

@Composable
fun StarWarsTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = lightColors.secondary
    )
    systemUiController.setSystemBarsColor(
        color = lightColors.secondary
    )
    MaterialTheme(
        colorScheme = lightColors,
        content = content
    )
}