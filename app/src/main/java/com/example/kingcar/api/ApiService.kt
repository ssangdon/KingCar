package com.example.kingcar.api
import com.example.kingcar.model.Article
import com.example.kingcar.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("get")
    fun getPosts(): Call<List<Post>>
//    @GET("your-api-endpoint") // 실제 API 엔드포인트를 적절히 대체
//    fun getArticles(): Call<Article>
    @GET("articles")
    fun getArticles(
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int
    ): Call<Article>
}