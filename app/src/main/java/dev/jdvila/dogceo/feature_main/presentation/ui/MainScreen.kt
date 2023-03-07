@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jdvila.dogceo.feature_main.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.jdvila.dogceo.R
import dev.jdvila.dogceo.core.presentation.components.SingleTextButton
import dev.jdvila.dogceo.core.presentation.ui.Screen
import dev.jdvila.dogceo.core.presentation.ui.theme.DarkGray
import dev.jdvila.dogceo.core.presentation.ui.theme.StarWarsTheme

@Composable
fun MainScreen(navController: NavHostController) {
    val route = stringResource(id = R.string.breeds_type, Screen.BreedsListScreen.route)
    StarWarsTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            stringResource(id = R.string.app_name), color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                )
            },
        ) {
            Surface(
                color = DarkGray,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                Column(
                    modifier = Modifier.fillMaxSize(0.5f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SingleTextButton(title = stringResource(id = R.string.dog_breeds), onClick = {
                        navController.navigate(route = route) {
                            popUpTo(Screen.MainScreen.route)
                        }
                    })
                }
            }
        }
    }
}