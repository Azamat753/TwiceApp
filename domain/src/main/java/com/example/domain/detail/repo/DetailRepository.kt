package com.example.domain.detail.repo

import com.example.core.base.BaseResult
import com.example.domain.detail.entity.DetailEntity
import com.example.domain.news.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    suspend fun getDetail(): Flow<BaseResult<List<DetailEntity>, String>>
}