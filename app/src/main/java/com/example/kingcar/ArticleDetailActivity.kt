package com.example.kingcar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kingcar.model.ArticleDetail
import com.example.kingcar.network.APIClient
import com.example.kingcar.network.APImanager
import com.example.kingcar.network.ApiService
import com.example.test.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var apiManager: APImanager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        val articleId: Int = intent.getIntExtra("articleId", -1)
        val requestButton = findViewById<Button>(R.id.wantDrive)
        requestButton.setOnClickListener{
            requestDrive("14",articleId)
        }
        apiManager = APImanager(APIClient.client.create(ApiService::class.java))
        if (articleId != -1) {
            getArticleDetails(articleId)
        }
    }

    private fun getArticleDetails(articleId: Int) {
        apiManager.getArticleDetails(articleId, object : Callback<ArticleDetail> {
            override fun onResponse(call: Call<ArticleDetail>, response: Response<ArticleDetail>) {
                if (response.isSuccessful) {
                    val article: ArticleDetail? = response.body()
                    article?.let {
                        updateUI(it)
                    }
                } else {
                    // 서버 응답 실패 시 처리
                }
            }
            override fun onFailure(call: Call<ArticleDetail>, t: Throwable) {
                // 네트워크 오류 등 호출이 실패한 경우 처리
            }
        })
    }
    private fun requestDrive(memberId:String, articleId: Int){
        apiManager.sendRequestDrive(memberId,articleId,object :Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("TESTLOG",response.toString())
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    private fun updateUI(article: ArticleDetail) {
        val detailImageView = findViewById<ImageView>(R.id.detailImageView)
        val courseImageView = findViewById<ImageView>(R.id.courseImageView)
        // Article 정보를 화면에 표시하는 코드 작성
        Glide.with(this)
            .load(article.image)
            .placeholder(R.drawable.search)
            .into(detailImageView)

        findViewById<TextView>(R.id.detailNickNameTextView).text = article.nickname
        findViewById<TextView>(R.id.detailTitleTextView).text = article.title
        findViewById<TextView>(R.id.detailContentTextView).text = article.contents

        findViewById<TextView>(R.id.detailPriceTextView).text = article.price.toString()
        findViewById<TextView>(R.id.detailRequestCount).text = "${article.requestCount}명 신청 중"

        if(article.courseId == 1){
            courseImageView.setBackgroundResource(R.drawable.hangang_course)
        }else if(article.courseId == 2) {
            courseImageView.setBackgroundResource(R.drawable.gyeongbok_course)
        }

        // 추가적으로 필요한 정보들을 표시하도록 작성
    }
}
//val articleId: Int,
//val title: String,
//val nickname: String,
//val image: String,
//val contents: String,
//val connection: Boolean,
//val courseId: Int,
//val price: Int,
//val writerCarBrand: String,
//val writerCarModel: String