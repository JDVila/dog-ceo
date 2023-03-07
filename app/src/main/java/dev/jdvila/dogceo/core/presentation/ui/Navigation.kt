package dev.jdvila.dogceo.core.presentation.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.jdvila.dogceo.feature_breeds.presentation.ui.BreedImagesScreen
import dev.jdvila.dogceo.feature_breeds.presentation.ui.BreedsListScreen
import dev.jdvila.dogceo.feature_main.presentation.ui.MainScreen

@Composable
fun Navigation(owner: ViewModelStoreOwner) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route, content = { MainScreen(navController) })
        composable(
            route = "${Screen.BreedsListScreen.route}/{type}",
            arguments = listOf(navArgument("type") { type = NavType.StringType })
        ) {
            it.arguments?.getString("type")
                ?.let { it1 -> BreedsListScreen(owner, navController, it1) }
        }
        composable(
            route = "${Screen.BreedImagesScreen.route}/{breed}",
            arguments = listOf(navArgument("breed") { type = NavType.StringType })
        ) {
            it.arguments?.getString("breed")?.let { it1 ->
                BreedImagesScreen(owner, navController, it1)
            }
        }
    }
}