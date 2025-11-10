package com.leoevg.mihnewsapp.presentation.screen.login

import com.leoevg.mihnewsapp.domain.util.Result
sealed class LoginScreenEvent{
    data class EmailUpdated(val newEmail: String): LoginScreenEvent()
    data class PasswordUpdated(val newPassword: String): LoginScreenEvent()
    data object LoginBtnClicked: LoginScreenEvent()
}

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    var loginResult: Result? = null
)
