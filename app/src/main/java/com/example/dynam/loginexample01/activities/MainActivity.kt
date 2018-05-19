package com.example.dynam.loginexample01.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dynam.loginexample01.R
import com.example.dynam.loginexample01.R.id.*
import com.example.dynam.loginexample01.database.REGEX_ID
import com.example.dynam.loginexample01.database.REGEX_PW
import com.example.dynam.loginexample01.database.User
import com.example.dynam.loginexample01.database.validateRegex
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Realm.init(this)
        var config = RealmConfiguration.Builder().build()
        realm = Realm.getInstance(config)

        btn_login.setOnClickListener {

            val tt: RealmResults<User> = realm.where<User>(User::class.java).findAll()
            for (user in tt) {
                if(!validateRegex(REGEX_ID, txt_id.text.toString()))
                    toast("아이디를 다시 입력해주세요.")
                else if(!validateRegex(REGEX_PW, txt_pw.text.toString()))
                    toast("패스워드를 다시 입력해주세요.")
                else if(user.id == txt_id.text.toString() && user.pw == txt_pw.text.toString())
                    startActivity<SuccessActivity>("LOGIN_ID" to txt_id.text.toString())
                else
                    toast("입력하신 회원정보는 존재하지 않습니다.")
            }
        }

        btn_join.setOnClickListener {
            startActivity<JoinActivity>()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
