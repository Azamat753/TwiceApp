package com.example.data.detail.module

import com.example.data.detail.repo.DetailRepositoryImpl
import com.example.data.news.repo.NewsRepositoryImpl
import com.example.domain.detail.repo.DetailRepository
import com.example.domain.news.repo.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent :: class)
interface DetailModule {
    @Binds
    fun bindDetailRepo(
        detailRepositoryImpl: DetailRepositoryImpl
    ): DetailRepository
}