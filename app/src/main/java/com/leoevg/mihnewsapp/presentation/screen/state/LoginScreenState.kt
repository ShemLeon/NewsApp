package com.leoevg.mihnewsapp.presentation.screen.state

import com.leoevg.mihnewsapp.util.util.Result
sealed class LoginScreenEvent{
    data class EmailUpdated(val email: String): LoginScreenEvent()
    data class PasswordUpdated(val password: String): LoginScreenEvent()
    data object LoginBtnClicked: LoginScreenEvent()
}

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    var loginResult: Result? = null
)
