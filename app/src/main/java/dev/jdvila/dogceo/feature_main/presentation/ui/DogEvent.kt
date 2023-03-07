package dev.jdvila.dogceo.feature_main.presentation.ui

sealed class DogEvent(val type: String? = null) {
    object LoadDogBreedsList : DogEvent(type = "breeds")
    data class LoadDogBreedImagesList(val breed: String?) : DogEvent()
    object LoadRandomDog : DogEvent(type = "random")

    companion object {
        fun withArgs(type: String): DogEvent {
            return when (type) {
                LoadDogBreedsList.type -> LoadDogBreedsList
                LoadRandomDog.type -> LoadRandomDog
                else -> throw Exception()
            }
        }
    }
}