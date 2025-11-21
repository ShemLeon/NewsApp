package com.leoevg.mihnewsapp.data.repository

import android.content.Context
import androidx.core.content.edit

class LocalAuthManager(context: Context){
    private val sharedPreferences = context.getSharedPreferences("news_app_auth_prefs", Context.MODE_PRIVATE)

    fun rememberAuth(id: String) {
        sharedPreferences.edit(commit = true) { putString("id", id) }
    }

    fun isLoggedIn(): Boolean{
        return sharedPreferences.getString("id", null) != null
    }

    fun signOut(){
        sharedPreferences.edit(commit = true) { remove("id") }
    }

}


// Класс создан для избегания повторной аутентификации,
// если пользователь зашел однажды - нет нужды повторно загонять пароль