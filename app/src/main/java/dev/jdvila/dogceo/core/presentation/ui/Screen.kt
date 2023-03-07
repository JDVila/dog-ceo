package dev.jdvila.dogceo.core.presentation.ui

sealed class Screen(val route: String) {
    object MainScreen : Screen(route = "main_screen")
    object BreedsListScreen : Screen(route = "breeds_list_screen")
    object BreedImagesScreen : Screen(route = "breed_images_screen")
}
