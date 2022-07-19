package com.example.domain.participants.entity

data class ParticipantEntity(
    val id: String,
    val image: String,
    val name: String,
    val job: String
) {
    companion object {
        fun onCreate(id: String, image: String, name: String, job: String)
                : ParticipantEntity = ParticipantEntity(
            id, image, name, job
        )
    }
}
