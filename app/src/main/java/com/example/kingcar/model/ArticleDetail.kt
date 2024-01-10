package com.example.kingcar.model

data class ArticleDetail(
    val articleId: Int,
    val title: String,
    val nickname: String,
    val image: String,
    val contents: String,
    val connection: Boolean,
    val courseId: Int,
    val price: Int,
    val writerCarBrand: String,
    val writerCarModel: String,
    var requestCount : Int
)