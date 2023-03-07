@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package dev.jdvila.dogceo.feature_breeds.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import dev.jdvila.dogceo.feature_main.presentation.ui.DogEvent
import dev.jdvila.dogceo.R
import dev.jdvila.dogceo.core.presentation.components.SingleTextTile
import dev.jdvila.dogceo.core.presentation.ui.Screen
import dev.jdvila.dogceo.core.presentation.ui.theme.DarkGray
import dev.jdvila.dogceo.core.presentation.ui.theme.StarWarsTheme

@Composable
fun BreedsListScreen(owner: ViewModelStoreOwner, navController: NavHostController, path: String) {
    val viewModel = hiltViewModel<BreedsViewModel>(viewModelStoreOwner = owner)
    viewModel.onEvent(DogEvent.withArgs(path))
    val state = viewModel.listState.observeAsState()
    StarWarsTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            stringResource(id = R.string.dog_breeds),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                    navigationIcon = {
                        IconButton(content = {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Go Back",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }, onClick = { navController.popBackStack() })
                    }
                )
            },
        ) {
            Surface(
                color = DarkGray,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (state.value) {
                        is BreedsState.LoadingListState -> CircularProgressIndicator()
                        is BreedsState.SuccessListState -> LazyColumn(modifier = Modifier.fillMaxHeight()) {
                            items(
                                items = (state.value as BreedsState.SuccessListState).result,
                                itemContent = { item ->
                                    SingleTextTile(text = item, onClick = {
                                        navController.navigate(route = "${Screen.BreedImagesScreen.route}/$item") {
                                            popUpTo(Screen.BreedsListScreen.route)
                                        }})
                                })
                        }

                        is BreedsState.ErrorListState -> {
                            Text(
                                text = "THERE WAS AN ERROR: ${(state.value as BreedsState.ErrorListState).msg}",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        else -> throw Exception()
                    }
                }
            }
        }
    }
}