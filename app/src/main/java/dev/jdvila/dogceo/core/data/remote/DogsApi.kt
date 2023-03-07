package dev.jdvila.dogceo.core.data.remote

import dev.jdvila.dogceo.feature_breeds.data.BreedsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApi {

    @GET("/api/breeds/list")
    suspend fun getDogBreeds(): Response<BreedsListResponse>

    @GET("/api/breed/{breedName}/images")

    suspend fun getDogBreedImages(@Path("breedName") breedName: String): Response<BreedsListResponse>

    companion object {
        const val BASE_URL = "https://dog.ceo"
    }
}