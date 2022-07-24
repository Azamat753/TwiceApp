package com.siroca.twiceapp.ui.fragment.details

import androidx.lifecycle.viewModelScope
import com.example.core.base.*
import com.example.domain.detail.entity.DetailEntity
import com.example.domain.detail.use_case.GetDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getDetailUseCase: GetDetailUseCase
): BaseViewModel(){
    private val _detailResult: MutableStateResult<List<DetailEntity>, String> =
        MutableStateFlow(PendingResult)
    val detailResult: StateResult<List<DetailEntity>, String> get() = _detailResult

    init {
        fetchDetail()
    }

    private fun fetchDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            getDetailUseCase.getDetail()
                .onStart {
                    _detailResult.value = PendingResult
                }
                .catch {
                    _detailResult.value = ErrorResult(it.message.toString())
                }
                .collect {
                    _detailResult.value = it
                }
        }
    }

    fun tryAgain() {
        fetchDetail()
    }
}