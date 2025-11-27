package com.leoevg.mihnewsapp.presentation.screen.main.feed

import com.leoevg.mihnewsapp.domain.model.NewsItem

data class FeedScreenState(
    val searchQuery: String = "",
    val filteredNews: List<NewsItem> = emptyList()
)