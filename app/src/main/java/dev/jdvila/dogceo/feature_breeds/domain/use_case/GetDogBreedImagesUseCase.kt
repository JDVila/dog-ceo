package dev.jdvila.dogceo.feature_breeds.domain.use_case

import dev.jdvila.dogceo.core.data.remote.DogsAPIResponse
import dev.jdvila.dogceo.feature_breeds.data.BreedsListResponse
import dev.jdvila.dogceo.feature_breeds.domain.respository.DogsRepository

class GetDogBreedImagesUseCase(
    private val repository: DogsRepository
) {
    suspend operator fun invoke(breed: String): DogsAPIResponse<BreedsListResponse> {
        return repository.getDogBreedImagesList(breed)
    }
}