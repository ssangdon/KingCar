package com.example.kingcar.network

import com.example.kingcar.model.ApiResponse
import com.example.kingcar.model.Article
import com.example.kingcar.model.ArticleDetail
import com.example.kingcar.model.MemberRequest
import com.example.kingcar.model.RequestDrive
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class APImanager(private val apiService: ApiService) {
    fun getArticles(pageNumber: Int, pageSize: Int, callback: (Article?) -> Unit) {
        apiService.getArticles(pageNumber, pageSize).enqueue(object : Callback<Article> {
            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }
            override fun onFailure(call: Call<Article>, t: Throwable) {
                callback(null)
            }
        })
    }
    fun getArticleDetails(articleId: Int, callback: Callback<ArticleDetail>) {
        val call: Call<ArticleDetail> = apiService.getArticleDetails(articleId)
        call.enqueue(callback)
    }


    fun sendRequestDrive(memberId:String, articleId: Int, callback: Callback<String>){
        val articleRequest = RequestDrive(articleId)
        val call : Call<String> = apiService.sendRequest(memberId, articleRequest)
        call.enqueue(callback)
    }

    fun createMember(nickname:String, callback: Callback<ApiResponse>){
        val registerRequest = MemberRequest(nickname)
        val call : Call<ApiResponse> = apiService.createMember(registerRequest)
        call.enqueue(callback)
    }
    fun login(nickname: String, callback: Callback<ApiResponse>) {
        val call = apiService.login(nickname)
        call.enqueue(callback)
    }

    // 다른 API 호출 메서드들도 필요에 따라 추가
}