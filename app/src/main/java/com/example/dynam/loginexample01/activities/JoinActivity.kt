package com.example.dynam.loginexample01.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dynam.loginexample01.R
import com.example.dynam.loginexample01.database.*
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_join.*
import org.jetbrains.anko.toast

class JoinActivity : AppCompatActivity() {
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        var config = RealmConfiguration.Builder().build()
        realm = Realm.getInstance(config)

        btn_signup.setOnClickListener {
            if(!validateRegex(REGEX_ID, txt_joinID.text.toString()))
                toast("아이디를 다시 입력해주세요.")

            else if(!validateRegex(REGEX_PW, txt_joinPW1.text.toString())
                    || !validateRegex(REGEX_PW, txt_joinPW2.text.toString()))
            {
                toast("패스워드를 다시 입력해주세요.")
            }
            else if(txt_joinPW1.text.toString() != txt_joinPW2.text.toString())
                toast("패스워드가 일치하지 않습니다.")

            else if(!validateRegex(REGEX_ID, txt_joinID.text.toString())
                    || !validateRegex(REGEX_PW, txt_joinPW1.text.toString())
                    || !validateRegex(REGEX_EMAIL, txt_joinEmail.text.toString()))
            {
                toast("입력하신 정보를 다시 확인해주세요.")
            }

            else {
                realm.executeTransaction {
                    val user: User = it.createObject(User::class.java)
                    user.id = txt_joinID.text.toString()
                    user.pw = txt_joinPW1.text.toString()
                }
                finish()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}