package com.vuonghung.dpz.utils

/**
 * Responsible to communicate the current state of Network Call to the UI Layer.
 * */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data , null)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

/** UI State*/
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}