package com.example.librarypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileImg.setOnClickListener {

//            프로필 크게 보는 액티비티로 이동.
                val myIntent = Intent(this, ViewProfilePhotoActivity::class.java)
                startActivity(myIntent)
        }

//        인터넷에 있는 이미지 (https://....)를 이미지 뷰에 바로 대입.
         Glide.with(this).load("https://w.namu.la/s/06a5552f91690e047c583957b3435f164ccb5404a162429278b62e20c5a09fdf72f086cc3c28a9faa6aaf3c42c45e3ed37a6cdb5ea32a1f0a9e966660248e7c582bb43fa917a99784057eb9be95b0edc90ccae6800bc162cc08dcb26f5dde0a1").into(characterImg)


    }
}