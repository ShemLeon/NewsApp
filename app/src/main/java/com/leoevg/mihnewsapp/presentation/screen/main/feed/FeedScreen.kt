package com.leoevg.mihnewsapp.presentation.screen.main.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.leoevg.mihnewsapp.domain.model.NewsItem
import com.leoevg.mihnewsapp.presentation.ui.component.NewsItem as NewsItemView
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month

@Composable
fun FeedScreen() {
    var searchText by remember { mutableStateOf("") }

    val sampleNewsItems = listOf(
        NewsItem(
            id = "1",
            title = "Breaking News: Compose Simplifies UI Development",
            description = "Jetpack Compose is revolutionizing Android UI development with its declarative approach.",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:AND9GcTuNlsfnHCpJNqy_3bE_Qk1K3HWiUkggy8z8g&s",
            isFavorite = false,
            publishedBy = "Tech News Daily",
            publishedAt = LocalDateTime(year = 2024, month = Month.JUNE, day = 15, hour = 10, minute = 0),
            content = ""
        ),
        NewsItem(
            id = "2",
            title = "Kotlin Multiplatform: One Language, Many Platforms",
            description = "Kotlin Multiplatform allows developers to share code across multiple platforms seamlessly.",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:AND9GcTuNlsfnHCpJNqy_3bE_Qk1K3HWiUkggy8z8g&s",
            isFavorite = true,
            publishedBy = "Dev Weekly",
            publishedAt = LocalDateTime(year = 2024, month = Month.JUNE, day = 14, hour = 9, minute = 30),
            content = ""
        ),
        NewsItem(
            id = "3",
            title = "Android 14: What's New?",
            description = "Explore the latest features and improvements in Android 14.",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:AND9GcTuNlsfnHCpJNqy_3bE_Qk1K3HWiUkggy8z8g&s",
            isFavorite = false,
            publishedBy = "Android Central",
            publishedAt = LocalDateTime(year = 2024, month = Month.JUNE, day = 13, hour = 14, minute = 15),
            content = ""
        )
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(sampleNewsItems) { newsItem ->
                NewsItemView(
                    newsItem = newsItem,
                    onFavoriteClicked = {},
                    onReadClicked = {}
                )
            }
        }
    }
}
