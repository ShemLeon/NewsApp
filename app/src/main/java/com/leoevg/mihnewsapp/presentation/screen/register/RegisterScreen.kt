package com.leoevg.mihnewsapp.presentation.screen.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leoevg.mihnewsapp.presentation.navigation.Screen
import com.leoevg.mihnewsapp.R
import com.leoevg.mihnewsapp.presentation.ui.component.StyledButton
import com.leoevg.mihnewsapp.domain.util.Result

@Composable
fun RegisterScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    val viewModel = hiltViewModel<RegisterScreenViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current
    LaunchedEffect(state.registerResult) {
        state.registerResult?.let { registerResult ->
            when (registerResult) {
                is Result.Success<*> -> {
                    onNavigateTo(Screen.Main)
                }
                is Result.Failure<*> -> {
                    Toast.makeText(context, registerResult.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    RegisterView(
        state = state,
        onEvent = viewModel::onEvent,
        onNavigateTo = onNavigateTo
    )
}

@Composable
fun RegisterView(
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent) -> Unit = {},
    onNavigateTo: (Screen) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 100.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "News app login img",
            modifier = Modifier
                .size(160.dp)
                .padding(top = 20.dp)
        )
        // username
        OutlinedTextField(
            value = state.username,
            onValueChange = {
                onEvent(RegisterScreenEvent.UsernameUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.ThumbUp),
                    contentDescription = "username"
                )
            },
            modifier = Modifier
                .padding(top = 10.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.enter_username))
            }
        )
        // email
        OutlinedTextField(
            value = state.email,
            onValueChange = {
                onEvent(RegisterScreenEvent.EmailUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = "Email"
                )
            },
            modifier = Modifier
                .padding(top = 10.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.enter_email))
            }
        )
        // password
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 10.dp),
            value = state.password,
            onValueChange = {
                onEvent(RegisterScreenEvent.PasswordUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = "password"
                )
            },

            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(text = stringResource(id = R.string.enter_password))
            }
        )

        StyledButton(
            onClick = {
                onEvent(RegisterScreenEvent.RegisterBtnClicked)
            },
            modifier = Modifier
                .padding(top = 10.dp, bottom = 30.dp)
        ) {
            Text(text = "Регистрация")
        }

        Text(
            text = stringResource(id = R.string.already_have_an_account),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable {
                    onNavigateTo(Screen.Login)
                }
        )
    }
}


@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview() {
    RegisterView()
}