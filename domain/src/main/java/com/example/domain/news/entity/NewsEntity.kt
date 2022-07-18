package com.example.domain.news.entity

data class NewsEntity(
    val title: String,
    val description: String,
    val image: String
) {
    companion object {
        fun onCreate(title: String, description: String, image: String)
                : NewsEntity = NewsEntity(
            title, description, image
        )
    }
}
