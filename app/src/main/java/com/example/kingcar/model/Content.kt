package com.example.kingcar.model

data class Content(
    val articleId: Int,
    val connection: Boolean,
    val image: String,
    val price: Int,
    val title: String,
    val writerCarBrand: String,
    val writerCarModel: String,
    val writerNickname: String
)
