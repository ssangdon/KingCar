package com.example.kingcar

import android.graphics.Color
import android.opengl.EGLImage
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.kingcar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.nicknameTextfield?.setText("초기값")
        isButtonValid()
    }

    fun isButtonValid(){
        val button = findViewById<Button>(R.id.nextButton)
        val textField = findViewById<EditText>(R.id.nickname_textfield)
        textField.addTextChangedListener{
            val nickName = findViewById<EditText>(R.id.nickname_textfield).text.toString()
            if(nickName.isEmpty()){
                button.isEnabled = false
                button.setBackgroundColor(Color.BLUE)
            }else{
                button.isEnabled = true
                button.setBackgroundColor(Color.BLACK)
            }

        }
        button.setOnClickListener{
            val nickName = findViewById<EditText>(R.id.nickname_textfield).text.toString()
                Toast.makeText(this@MainActivity,"닉네임을 입력해주세요",Toast.LENGTH_SHORT).show()

//            Toast.makeText(this@MainActivity,nickName,Toast.LENGTH_SHORT).show()
        }
    }

}