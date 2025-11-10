package com.leoevg.mihnewsapp.presentation.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.leoevg.mihnewsapp.presentation.navigation.Screen

@Composable
fun MainScreen(
    onNavigateTo:(Screen) -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MainScreen"
        )
    }
}