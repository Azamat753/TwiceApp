package com.example.data.news.module

import com.example.data.news.repo.NewsRepositoryImpl
import com.example.domain.news.repo.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NewsModule {
    @Binds
    fun bindNewsRepo(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}