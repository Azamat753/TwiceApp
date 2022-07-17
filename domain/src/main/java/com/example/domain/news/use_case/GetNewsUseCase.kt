package com.example.domain.news.use_case

import com.example.core.base.BaseResult
import com.example.domain.news.entity.NewsEntity
import com.example.domain.news.repo.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend fun getNews(): Flow<BaseResult<List<NewsEntity>, String>> = repository.getNews()
}