package com.example.kingcar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R

class SelectCourseActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    var i = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_course)
        imageView = findViewById(R.id.itemImageView1)
        imageView.setOnClickListener {
            // 클릭할 때마다 이미지 변경
            Log.d("TESTLOG", "CLicked")
            i = if (i) {
                imageView.setImageResource(R.drawable.hangang_course_active)
                false
            } else {
                imageView.setImageResource(R.drawable.hangang_course)
                true
            }
        }
        goMainBoardPage()
    }
    fun goMainBoardPage(){
        val button = findViewById<Button>(R.id.complete)
        button.setOnClickListener{
            val intent = Intent(this, MainBoardActivity::class.java)
            startActivity(intent)
        }
    }

}