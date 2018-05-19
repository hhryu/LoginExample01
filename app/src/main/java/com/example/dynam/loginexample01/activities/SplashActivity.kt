package com.example.dynam.loginexample01.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dynam.loginexample01.database.User
import io.realm.Realm
import io.realm.RealmConfiguration
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SplashActivity : AppCompatActivity() {
//    lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Realm.init(this)

//        val config = RealmConfiguration.Builder().build()
//        realm = Realm.getInstance(config)
//        val userInfo = realm.where(User::class.java).findAll()

        startActivity<MainActivity>()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
//        realm.close()
    }
}