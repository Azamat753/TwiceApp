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
) {
    companion object{
        fun onCreate(id: String, idFacts: String, idImage:String, images:List<String>,
                    realNamesFirst: String, realNamesSecond: String, nickName: String,
                    education: String, career: String, height: String, weight: String,
                    birthday: String, placeBirthday: String) : DetailEntity = DetailEntity(
            id, idFacts, idImage, images, realNamesFirst, realNamesSecond, nickName, education,
            career, height, weight, birthday, placeBirthday
        )
    }
}
