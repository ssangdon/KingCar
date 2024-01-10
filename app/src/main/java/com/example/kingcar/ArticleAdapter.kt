package com.example.kingcar

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kingcar.model.Content
import com.example.test.R
import org.w3c.dom.Text

class ArticleAdapter(private val articles: List<Content>, private val onItemClick: (Content) -> Unit) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        // 아이템 뷰에 데이터 설정
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onItemClick(article)
        }
    }
    override fun getItemCount(): Int {
        return articles.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("ResourceAsColor")
        fun bind(article: Content) {
            // 아이템 뷰에 데이터를 설정하는 로직 추가
            val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
            val itemTitleTextView: TextView = itemView.findViewById(R.id.itemTitleTextView)
            val itemWriterTextView: TextView = itemView.findViewById(R.id.itemWriterTextView)
            val itemPriceTextView: TextView = itemView.findViewById(R.id.itemPriceTextView)

            Glide.with(itemView.context)
                .load(article.image)
                .placeholder(R.drawable.search)
                .into(itemImageView)

            itemTitleTextView.text = article.title
            itemWriterTextView.text = article.writerNickname
            itemPriceTextView.text = "${article.price}"

        }
    }
}