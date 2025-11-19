package com.leoevg.mihnewsapp.domain.util

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val icon: ImageVector,
    val titleResId: Int,
    val route: Any
)