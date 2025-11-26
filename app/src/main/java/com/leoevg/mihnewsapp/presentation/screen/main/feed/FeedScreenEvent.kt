package com.leoevg.mihnewsapp.presentation.screen.main.feed

import com.leoevg.mihnewsapp.domain.model.NewsItem

interface FeedScreenEvent {
    data class SearchQueryChanged(val newSearchQuery: String) : FeedScreenEvent
    data class NewsItemClicked(val newsItem: NewsItem) : FeedScreenEvent
}
