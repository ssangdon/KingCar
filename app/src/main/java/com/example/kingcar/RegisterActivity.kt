package com.example.kingcar

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.kingcar.model.ApiResponse
import com.example.kingcar.network.APIClient
import com.example.kingcar.network.APImanager
import com.example.kingcar.network.ApiService
import com.example.test.R
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var apiManager: APImanager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        apiManager = APImanager(APIClient.client.create(ApiService::class.java))
        isButtonValid()
        val button = findViewById<Button>(R.id.nextButton)
        val textField = findViewById<EditText>(R.id.nickNameTextField)
        button.setOnClickListener{
            requestRegister(textField.text.toString())
        }
    }
    @SuppressLint("ResourceAsColor")
    fun isButtonValid(){
        val button = findViewById<Button>(R.id.nextButton)
        val textField = findViewById<EditText>(R.id.nickNameTextField)
        textField.addTextChangedListener{
            val nickname = textField.text.toString()
//            닉네임 중복검사 로직 필요
            if(nickname.isEmpty()){
                button.setBackgroundColor(Color.parseColor("#898F96"))
                button.isEnabled = false
            }else{
                button.setBackgroundColor(Color.parseColor("#C2FF41"))
                button.isEnabled = true
            }

        }
    }

    private fun requestRegister(nickname: String){
        apiManager.createMember(nickname, object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if(response.isSuccessful){
                    Log.d("testLog","111₩1111")
                    val memberId = response.body()?.memberId ?: -1
                    val intent = Intent(this@RegisterActivity, CarSelectActivity::class.java)
                    intent.putExtra("memberId", memberId)
                    startActivity(intent)
                    println("Registration successful! MemberId: $memberId")
                }else{
                    Log.d("testLog","실패")
                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("testLog",nickname)
                Log.d("testLog",t.toString())
            }
        })
    }

}