package com.leoevg.mihnewsapp.presentation.screen.main.navigation

import kotlinx.serialization.Serializable

sealed interface MainScreenNavigationRoute {
    @Serializable
    data object Feed: MainScreenNavigationRoute

    @Serializable
    data object Profile: MainScreenNavigationRoute
}