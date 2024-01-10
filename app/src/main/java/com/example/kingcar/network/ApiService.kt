package com.example.kingcar.network
import com.example.kingcar.model.ApiResponse
import com.example.kingcar.model.Article
import com.example.kingcar.model.ArticleDetail
import com.example.kingcar.model.MemberRequest
import com.example.kingcar.model.RequestDrive
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("articles")
    fun getArticles(@Query("pageNumber") pageNumber: Int, @Query("pageSize") pageSize: Int): Call<Article>

    @GET("articles/{articleId}")
    fun getArticleDetails(@Path("articleId") articleId: Int): Call<ArticleDetail>

    @POST("/requests/{memberId}")
    fun sendRequest(
        @Path("memberId") memberId: String,
        @Body request: RequestDrive
    ): Call<String>

    @POST("/members")
    fun createMember(
        @Body request: MemberRequest
    ): Call<ApiResponse>

    @POST("/members/{nickname}")
    fun login(@Path("nickname") nickname: String): Call<ApiResponse>
}