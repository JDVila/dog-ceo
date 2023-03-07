package dev.jdvila.dogceo.di

import dev.jdvila.dogceo.core.data.remote.DogsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jdvila.dogceo.feature_breeds.data.DogsRepositoryImpl
import dev.jdvila.dogceo.feature_breeds.domain.respository.DogsRepository
import dev.jdvila.dogceo.feature_breeds.domain.use_case.DogsUseCases
import dev.jdvila.dogceo.feature_breeds.domain.use_case.GetDogBreedImagesUseCase
import dev.jdvila.dogceo.feature_breeds.domain.use_case.GetDogBreedsUseCase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DogsModule {

    @Provides
    @Singleton
    fun provideDogsApi(client: OkHttpClient): DogsApi {
        return Retrofit.Builder()
            .baseUrl(DogsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(DogsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStarWarsRepository(
        api: DogsApi
    ): DogsRepository {
        return DogsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideStarWarsListUseCases(repository: DogsRepository): DogsUseCases {
        return DogsUseCases(
            getDogBreeds = GetDogBreedsUseCase(repository),
            getDogBreedImages = GetDogBreedImagesUseCase(repository)
        )
    }
}