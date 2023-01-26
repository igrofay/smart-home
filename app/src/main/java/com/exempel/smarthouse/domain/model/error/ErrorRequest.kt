package com.exempel.smarthouse.domain.model.error

sealed class ErrorRequest: ErrorModel() {
    class DataNotFound(override val message: String? = null) : ErrorRequest()
}
