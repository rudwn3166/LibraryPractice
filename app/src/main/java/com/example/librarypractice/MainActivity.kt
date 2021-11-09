package com.example.librarypractice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
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

//        전화걸기 버튼 누른->권한확인/전화 연결
        
        callBtn.setOnClickListener { 
            
//            라이브러리 활용->전화 권한 확인->실제 전화 연결

//            오브젝트가 퍼미션 리스너라는 가이드 북을 가지고 변수에 저장하게 함
            val permissionListener = object : PermissionListener{
                override fun onPermissionGranted() {
//                    권한이 허용되었을 때
//                    실제로 전화 연결 진행
                    val myUri = Uri.parse("tel:010-2222-3333")
                    val myIntent =Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    권한이 거절되었을때,토스트로 권한 실패안내
                    Toast.makeText(this@MainActivity, "권한이 없어서,전화연결에 실패 했습니다", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}