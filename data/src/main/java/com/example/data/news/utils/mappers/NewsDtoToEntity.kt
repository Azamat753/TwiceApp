package com.example.data.news.utils.mappers

import com.example.core.base.BaseMapper
import com.example.data.news.dto.NewsDto
import com.example.domain.news.entity.NewsEntity

class NewsDtoToEntity : BaseMapper<NewsDto, NewsEntity> {
    override fun invoke(p1: NewsDto): NewsEntity = NewsEntity.onCreate(
        p1.title, p1.description, p1.image
    )
}