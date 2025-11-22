package com.leoevg.mihnewsapp.domain.model

data class NewsItem (
    val id: String,
    val title: String,
    val description: String,
    val publishedBy: String,
    val publishedAt: String,
    val imageUrl: String,
    val content: String,
    val isFavorite: Boolean
)