package com.leoevg.mihnewsapp.presentation.screen.viewmodel

import android.media.metrics.Event
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leoevg.mihnewsapp.data.repository.AuthRepository
import com.leoevg.mihnewsapp.presentation.screen.state.LoginScreenEvent
import com.leoevg.mihnewsapp.presentation.screen.state.LoginScreenState
import com.leoevg.mihnewsapp.presentation.screen.state.RegisterScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val  authRepository: AuthRepository
): ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    
    fun updateEmail(email: String){
        this.email = email
    }

    fun updatePassword(password: String){
        this.password = password
    }
    
    var state by mutableStateOf(LoginScreenState())
        private set

    fun onEvent(event: LoginScreenEvent){
        when(event){
            is LoginScreenEvent.EmailUpdated ->
                this.state = state.copy(email = event.email)
            is LoginScreenEvent.PasswordUpdated ->
                this.state = state.copy(password = event.password)
            LoginScreenEvent.LoginBtnClicked -> login()
        }
    }

    private fun login() = viewModelScope.launch(Dispatchers.IO) {
        val email = state.email
        val password = state.password
        if (email.isEmpty() || password.isEmpty()) return@launch

        val result = authRepository.login(email, password)
        this@LoginScreenViewModel.state = state.copy(loginResult = result)
    }
}