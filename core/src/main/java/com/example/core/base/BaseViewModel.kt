package com.example.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

typealias StateResult<T, N> = StateFlow<BaseResult<T, N>>
typealias MutableStateResult<T, N> = MutableStateFlow<BaseResult<T, N>>
typealias SharedResult<T, N> = SharedFlow<BaseResult<T, N>>
typealias MutableSharedResult<T, N> = MutableSharedFlow<BaseResult<T, N>>


abstract class BaseViewModel : ViewModel() {


    /**
    arguments listener for result from other fragments
     */
    open fun onResult(result: Any) {

    }

}