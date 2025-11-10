package com.leoevg.mihnewsapp.presentation.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leoevg.mihnewsapp.data.repository.AuthRepository
import com.leoevg.mihnewsapp.presentation.screen.state.LoginScreenEvent
import com.leoevg.mihnewsapp.presentation.screen.state.LoginScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    var state by mutableStateOf(LoginScreenState())
        private set

    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.EmailUpdated -> this.state = state.copy(email = event.newEmail)
            is LoginScreenEvent.PasswordUpdated -> this.state = state.copy(password = event.newPassword)
            LoginScreenEvent.LoginBtnClicked -> login()
        }
    }
    private fun login(){
        val email = state.email
        val password = state.password
        val result = authRepository.login(email, password)
        this.state = state.copy(loginResult = result)
        if (email.isEmpty() || password.isEmpty()) return@launch


        this@LoginScreenViewModel.state = state.copy(loginResult = result)
    }
}