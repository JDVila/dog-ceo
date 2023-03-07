package dev.jdvila.dogceo.core.data.remote

data class DogsAPIResponse<T>(
    val successful: Boolean,
    val message: String? = null,
    val data: T? = null
)