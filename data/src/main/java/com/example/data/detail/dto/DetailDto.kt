package com.example.data.detail.dto

data class DetailDto(
    var id: String = "",
    var idFacts: String = "",
    var idImages: String = "",
    var images: List<String> ,
    var realNamesFirst: String = "",
    var realNamesSecond: String = "",
    var nickName: String = "",
    var education: String = "",
    var career: String = "",
    var height: String = "",
    var weight: String = "",
    var birthday: String = "",
    var placeBirthday: String = ""

)