package com.vuonghung.dpz.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

fun <T, A> performOperation(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<Resource<T>> = liveData(Dispatchers.IO) {
    emit(Resource.loading())
    val source = databaseQuery.invoke().map { Resource.success(it) }
    emitSource(source)

    val responseStatus = networkCall.invoke()
    if (responseStatus.status == Status.SUCCESS) {
        saveCallResult(responseStatus.data!!)

    } else if (responseStatus.status == Status.ERROR) {
        emit(Resource.error(responseStatus.message!!))
        emitSource(source)
    }
}

fun <T> performOperation(
    networkCall: suspend () -> Resource<T>
): LiveData<Resource<T>> = liveData(Dispatchers.IO) {
    emit(Resource.loading())
    val responseStatus = networkCall.invoke()
    if (responseStatus.status == Status.SUCCESS) {
        emit(responseStatus)
    } else if (responseStatus.status == Status.ERROR) {
        emit(responseStatus)
    }
}
