package com.siroca.twiceapp.ui.fragment.participants

import androidx.lifecycle.viewModelScope
import com.example.core.base.*
import com.example.domain.news.entity.NewsEntity
import com.example.domain.news.use_case.GetNewsUseCase
import com.example.domain.participants.entity.ParticipantEntity
import com.example.domain.participants.use_case.GetParticipantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParticipantsViewModel @Inject constructor(
    private val getParticipantsUseCase: GetParticipantsUseCase
) : BaseViewModel() {
    private val _newsResult: MutableStateResult<List<ParticipantEntity>, String> =
        MutableStateFlow(PendingResult)
    val newsResult: StateResult<List<ParticipantEntity>, String> get() = _newsResult

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch(Dispatchers.IO) {
            getParticipantsUseCase.getNews()
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