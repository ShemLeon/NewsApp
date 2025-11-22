package com.leoevg.mihnewsapp.domain.model

import kotlinx.datetime.LocalDateTime

data class NewsItem (
    val id: String,
    val title: String,
    val description: String,
    val publishedBy: String,
    val publishedAt: LocalDateTime,
    val imageUrl: String,
    val content: String,
    val isFavorite: Boolean
)