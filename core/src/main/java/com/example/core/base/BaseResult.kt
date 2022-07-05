package com.example.core.base

import java.lang.IllegalArgumentException

sealed class BaseResult<out T : Any, out N : Any> {
    fun <R : Any> map(mapper: BaseMapper<T, R>? = null): BaseResult<R, N> = when (this) {
        is PendingResult -> PendingResult
        is ErrorResult -> ErrorResult(this.errorMsg)
        is SuccessResult -> {
            if (mapper == null) throw IllegalArgumentException("Mapper should not by Null for success Result")
            SuccessResult(mapper(this.data))
        }
    }
}

object PendingResult : BaseResult<Nothing, Nothing>()

data class SuccessResult<T : Any>(
    val data: T
) : BaseResult<T, Nothing>()

data class ErrorResult<N : Any>(
    val errorMsg: N
) : BaseResult<Nothing, N>()

fun <T : Any, N : Any> BaseResult<T, N>?.takeSuccess(): T? {
    return if (this is SuccessResult)
        this.data
    else
        null
}
