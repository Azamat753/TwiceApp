package com.siroca.twiceapp.ui.fragment.news

import androidx.lifecycle.viewModelScope
import com.example.core.base.*
import com.example.domain.news.entity.NewsEntity
import com.example.domain.news.use_case.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : BaseViewModel() {
    private val _newsResult: MutableStateResult<List<NewsEntity>, String> =
        MutableStateFlow(PendingResult)
    val newsResult: StateResult<List<NewsEntity>, String> get() = _newsResult

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsUseCase.getNews()
                .onStart {
                    _newsResult.value = PendingResult
                }
                .catch {
                    _newsResult.value = ErrorResult(it.message.toString())
                }
                .collect {
                    _newsResult.value = it
                }
        }
    }

    fun tryAgain() {
        fetchNews()
    }
}