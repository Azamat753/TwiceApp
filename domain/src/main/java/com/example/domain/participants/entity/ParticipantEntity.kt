package com.example.domain.participants.entity

data class ParticipantEntity(
    val id: String,
    val name: String,
    val position_group: String,
    val image: String
) {
    companion object {
        fun onCreate(id: String, title: String, description: String, image: String)
                : ParticipantEntity = ParticipantEntity(
            id, title, description, image
        )
    }
}
