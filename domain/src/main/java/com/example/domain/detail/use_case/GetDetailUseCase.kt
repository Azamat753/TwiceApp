package com.example.domain.detail.use_case

import com.example.core.base.BaseResult
import com.example.domain.detail.entity.DetailEntity
import com.example.domain.detail.repo.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(
    private val repository: DetailRepository
) {
    suspend fun getDetail(): Flow<BaseResult<List<DetailEntity>, String>> = repository.getDetail()
}