package com.example.kingcar

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kingcar.network.ApiService
import com.example.kingcar.model.Content
import com.example.kingcar.network.APIClient
import com.example.kingcar.network.APImanager
import com.example.test.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainBoardActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var apiManager: APImanager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_board)
        apiManager = APImanager(APIClient.client.create(ApiService::class.java))
        recyclerView = findViewById(R.id.recyclerView)

        goWritePage()
        loadArticles()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemReselectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 reselection
//                    Log.d("testLog",bottomNavigation.menu.toString())
                    true
                }
                R.id.mypage -> {
                    // Respond to navigation item 2 reselection
                    true
                }
            }
        }
    }
    private fun loadArticles() {
        apiManager.getArticles(pageNumber = 0, pageSize = 10) { articles ->
            articles?.let {
                showArticles(it.content)
            } ?: run {
                Toast.makeText(this@MainBoardActivity, "게시글을 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showArticles(articles: List<Content>) {
//        val headerImageView: ImageView = findViewById(R.id.headerImageView)
        val adapter = ArticleAdapter(articles) { article ->
            // 클릭한 게시글의 상세 정보 페이지로 이동
            val intent = Intent(this, ArticleDetailActivity::class.java)
            intent.putExtra("articleId", article.articleId)
            startActivity(intent)
        }

//        Glide.with(this)
//            .load(articles.firstOrNull()?.image)
//            .placeholder(R.drawable.search)
//            .into(headerImageView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val marginInPixels = resources.getDimensionPixelSize(R.dimen.item_margin_bottom)
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
    private fun goWritePage() {
        val button = findViewById<ImageButton>(R.id.writePageButton)
        button.setOnClickListener{
            val intent = Intent(this, WriteArticleActivity::class.java)
            startActivity(intent)
        }
    }

}
