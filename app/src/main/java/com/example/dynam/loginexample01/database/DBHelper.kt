package com.example.dynam.loginexample01.database

import io.realm.RealmObject
import java.util.regex.Pattern

const val PREFS_NAME = "LOGIN_INFO"
const val REGEX_ID = "^[a-zA-Z0-9]{5,}$"
const val REGEX_PW = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$"
const val REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,3}$"

fun validateRegex(regex: String, str: String) : Boolean {
    val matcher = Pattern.compile(regex).matcher(str)
    return matcher.find()
}

open class User : RealmObject() {
    open var id: String? = null
    open var pw: String? = null
}
