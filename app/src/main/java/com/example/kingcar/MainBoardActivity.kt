package com.example.kingcar

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kingcar.api.ApiService
import com.example.kingcar.model.Article
import com.example.kingcar.model.Content
import com.example.kingcar.model.Post
import com.example.kingcar.network.ApiClient
import com.example.test.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainBoardActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_board)
        apiService = ApiClient.client.create(ApiService::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        fun showArticles(articles: List<Content>) {
            val headerImageView: ImageView = findViewById(R.id.headerImageView)
            val adapter = ArticleAdapter(articles)

            // 첫 번째 아이템의 이미지를 헤더로 사용
            Glide.with(this)
                .load(articles.firstOrNull()?.image)
                .placeholder(R.drawable.search)
                .into(headerImageView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            val marginInPixels = resources.getDimensionPixelSize(R.dimen.item_margin_bottom)

            // 아이템 간 마진 설정
            val itemDecoration = object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.top = marginInPixels
                }
            }
            recyclerView.addItemDecoration(itemDecoration)
            recyclerView.adapter = adapter
        }
        val call: Call<Article> = apiService.getArticles(pageNumber = 0, pageSize = 10)
        call.enqueue(object : Callback<Article> {
            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                if (response.isSuccessful) {
                    val articles: Article? = response.body()
                    articles?.let {
                        // 받아온 데이터를 화면에 표시하는 함수 호출
                        showArticles(it.content)
                    }
                } else {
                    // 서버 응답이 실패한 경우
                    // 처리 로직 추가

                }
            }
            override fun onFailure(call: Call<Article>, t: Throwable) {
                // 네트워크 오류 등 호출이 실패한 경우
                // 처리 로직 추가

            }
        })

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemReselectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 reselection
                }
                R.id.mypage -> {
                    // Respond to navigation item 2 reselection
                }
            }
        }
    }

}