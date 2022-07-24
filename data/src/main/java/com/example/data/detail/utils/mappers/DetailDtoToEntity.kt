package com.example.data.detail.utils.mappers

import com.example.core.base.BaseMapper
import com.example.data.detail.dto.DetailDto
import com.example.domain.detail.entity.DetailEntity

class DetailDtoToEntity : BaseMapper<DetailDto, DetailEntity> {
    override fun invoke(p1: DetailDto): DetailEntity = DetailEntity.onCreate(
        p1.id, p1.idFacts, p1.idImages, p1.images, p1.realNamesFirst, p1.realNamesSecond, p1.nickName,
        p1.education, p1.career, p1.height, p1.weight, p1.birthday, p1.placeBirthday
    )
}