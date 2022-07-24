package com.example.domain.participants.entity

data class ParticipantEntity(
    val id: String,
    val image: String,
    val nick_name: String,
    val position: String
) {
    companion object {
        fun onCreate(id: String, image: String, nick_name: String, position: String)
                : ParticipantEntity = ParticipantEntity(
            id, image, nick_name, position
        )
    }
}
