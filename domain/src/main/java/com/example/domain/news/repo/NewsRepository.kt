package com.example.domain.news.repo

import com.example.core.base.BaseResult
import com.example.domain.news.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<BaseResult<List<NewsEntity>, String>>
}