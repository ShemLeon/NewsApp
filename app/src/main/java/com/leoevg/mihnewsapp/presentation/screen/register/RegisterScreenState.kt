package com.leoevg.mihnewsapp.presentation.screen.register

import com.leoevg.mihnewsapp.domain.util.Result

sealed class RegisterScreenEvent{
    data class UsernameUpdated(val newUsername: String): RegisterScreenEvent()
    data class EmailUpdated(val newEmail: String): RegisterScreenEvent()
    data class PasswordUpdated(val newPassword: String): RegisterScreenEvent()
    data object RegisterBtnClicked: RegisterScreenEvent()
}

data class RegisterScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val registerResult: Result? = null
)
