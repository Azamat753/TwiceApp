package com.example.domain.detail.entity

data class DetailEntity(
    val id: String,
    val idFacts: String,
    val idImages: String,
    val images: List<String>,
    val realNamesFirst: String,
    val realNamesSecond: String,
    val nickName: String,
    val education: String,
    val career: String,
    val height: String,
    val weight: String,
    val birthday: String,
    val placeBirthday: String
)
