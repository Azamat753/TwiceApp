package com.example.domain.participants.use_case

import com.example.core.base.BaseResult
import com.example.domain.participants.entity.ParticipantEntity
import com.example.domain.participants.repo.ParticipantsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetParticipantsUseCase @Inject constructor(
    private val repository: ParticipantsRepository
) {
    suspend fun getParticipants(): Flow<BaseResult<List<ParticipantEntity>, String>> = repository.getParticipants()
}