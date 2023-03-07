package dev.jdvila.dogceo.feature_breeds.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jdvila.dogceo.feature_main.presentation.ui.DogEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jdvila.dogceo.feature_breeds.domain.use_case.DogsUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedImagesViewModel @Inject constructor(
    private val dogsUseCases: DogsUseCases
) : ViewModel() {
    var listState = MutableLiveData<BreedsState>(BreedsState.LoadingListState)

    fun onEvent(event: DogEvent) {
        viewModelScope.launch() {
            if(listState.value !is BreedsState.SuccessListState) listState.postValue(BreedsState.LoadingListState)
            when (event) {
                is DogEvent.LoadDogBreedImagesList -> {
                    val result = event.breed?.let { dogsUseCases.getDogBreedImages(it) }
                    if(result!!.successful) {
                        listState.postValue(BreedsState.SuccessListState(result.data!!.message))
                    } else {
                        listState.postValue(BreedsState.ErrorListState(result.message))
                    }
                }
                else -> throw Exception()
            }
        }
    }
}