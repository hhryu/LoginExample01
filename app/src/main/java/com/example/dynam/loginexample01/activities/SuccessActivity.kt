package com.example.dynam.loginexample01.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginInfo = intent.getStringExtra("LOGIN_ID")
        verticalLayout {
            padding = dip(100)
            textView("${loginInfo} 님이 접속하셨습니다.")
        }
    }
}
