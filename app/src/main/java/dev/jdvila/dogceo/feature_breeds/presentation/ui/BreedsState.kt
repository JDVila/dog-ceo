package dev.jdvila.dogceo.feature_breeds.presentation.ui

sealed class BreedsState(result: List<String>? = null, msg: String? = null) {
    object LoadingListState: BreedsState()
    data class SuccessListState(val result: List<String>): BreedsState(result = result)
    data class ErrorListState(val msg: String?): BreedsState(msg = msg)
}