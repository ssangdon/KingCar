package com.example.kingcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.test.R

class WriteArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_article)
        goNextPage()
    }
    fun goNextPage(){
        val button = findViewById<Button>(R.id.nextButton)
        val title = findViewById<EditText>(R.id.titleTextfield)
        val price = findViewById<EditText>(R.id.priceTextField)
        val detail = findViewById<EditText>(R.id.detailTextField)
        button.setOnClickListener{
            val intent = Intent(this, SelectCourseActivity::class.java)
            intent.putExtra("title", title.text.toString())
            intent.putExtra("price", price.text.toString())
            intent.putExtra("detail", detail.text.toString())
            startActivity(intent)
        }
    }
}