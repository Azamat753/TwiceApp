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

    private val _state = MutableStateFlow<BaseFragmentState>(BaseFragmentState.Init)
    protected val state: StateFlow<BaseFragmentState> get() = _state


    private fun showToast(message: String?) {
        _state.value = BaseFragmentState.ShowToast(message)
    }

    protected fun hideLoading() {
        _state.value = BaseFragmentState.IsLoading(false)
    }

    protected fun setLoading() {
        _state.value = BaseFragmentState.IsLoading(true)
    }


    protected fun setError(msg: String) {
        _state.value = BaseFragmentState.ShowToast(msg)
    }

    /**
     *arguments listener for result from other fragments
     */
    open fun onResult(result: Any) {

    }

    sealed class BaseFragmentState {
        object Init : BaseFragmentState()
        data class IsLoading(val isLoading: Boolean) : BaseFragmentState()
        data class ShowToast(val message: String?) : BaseFragmentState()
    }
}