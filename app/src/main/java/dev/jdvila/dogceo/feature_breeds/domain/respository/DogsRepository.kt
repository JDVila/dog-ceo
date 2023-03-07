package dev.jdvila.dogceo.feature_breeds.domain.respository

import dev.jdvila.dogceo.core.data.remote.DogsAPIResponse
import dev.jdvila.dogceo.feature_breeds.data.BreedsListResponse

interface DogsRepository {
    suspend fun getDogBreedList(
    ): DogsAPIResponse<BreedsListResponse>

    suspend fun getDogBreedImagesList(breed: String
    ): DogsAPIResponse<BreedsListResponse>
}