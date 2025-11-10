package com.leoevg.mihnewsapp.presentation.screen.main.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.leoevg.mihnewsapp.domain.util.BottomNavItem


@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val bottomNavItems = listOf(
        BottomNavItem(
            icon = Icons.Outlined.Home
        )
    )


    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
    ){

    }
}