package com.example.data.participants.utils.mappers

import com.example.core.base.BaseMapper
import com.example.data.participants.dto.ParticipantsDto
import com.example.domain.participants.entity.ParticipantEntity

class ParticipantsDtoToEntity : BaseMapper<ParticipantsDto, ParticipantEntity> {
    override fun invoke(p1: ParticipantsDto): ParticipantEntity = ParticipantEntity.onCreate(
        p1.id, p1.name, p1.job, p1.image
    )
}