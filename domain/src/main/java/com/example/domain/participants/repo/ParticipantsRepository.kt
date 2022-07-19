package com.example.domain.participants.repo

import com.example.core.base.BaseResult
import com.example.domain.participants.entity.ParticipantEntity
import kotlinx.coroutines.flow.Flow

interface ParticipantsRepository {
    suspend fun getParticipants(): Flow<BaseResult<List<ParticipantEntity>, String>>
}