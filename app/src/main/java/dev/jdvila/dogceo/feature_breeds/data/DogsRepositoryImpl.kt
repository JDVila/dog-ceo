package dev.jdvila.dogceo.feature_breeds.data

import dev.jdvila.dogceo.core.data.remote.DogsApi
import dev.jdvila.dogceo.core.data.remote.DogsAPIResponse
import dev.jdvila.dogceo.feature_breeds.domain.respository.DogsRepository
import retrofit2.HttpException
import java.io.IOException

class DogsRepositoryImpl(
    private val dogsApi: DogsApi,
) : DogsRepository {

    override suspend fun getDogBreedList(): DogsAPIResponse<BreedsListResponse> {
        return try {
            val response = dogsApi.getDogBreeds()
            if(response.isSuccessful) {
                DogsAPIResponse(successful = true, data = response.body())
            } else {
                DogsAPIResponse(successful = false, message = "Something went wrong :/")
            }
        } catch (e: IOException) {
            DogsAPIResponse(successful = false, message = "Something went wrong :/")
        } catch (e: HttpException) {
            DogsAPIResponse(successful = false, message = "Something went wrong :/")
        }
    }

    override suspend fun getDogBreedImagesList(breed: String): DogsAPIResponse<BreedsListResponse> {
        return try {
            val response = dogsApi.getDogBreedImages(breedName = breed)
            if(response.isSuccessful) {
                DogsAPIResponse(successful = true, data = response.body())
            } else {
                DogsAPIResponse(successful = false, message = "Something went wrong :/")
            }
        } catch (e: IOException) {
            DogsAPIResponse(successful = false, message = "Something went wrong :/")
        } catch (e: HttpException) {
            DogsAPIResponse(successful = false, message = "Something went wrong :/")
        }
    }
}