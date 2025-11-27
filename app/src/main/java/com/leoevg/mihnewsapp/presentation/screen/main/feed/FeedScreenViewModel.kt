package com.leoevg.mihnewsapp.presentation.screen.main.feed

import androidx.lifecycle.ViewModel
import com.leoevg.mihnewsapp.data.repository.NewsRepository
import com.leoevg.mihnewsapp.presentation.navigation.Screen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class FeedScreenViewModel @AssistedInject constructor(
    @Assisted val navigate: (Screen) -> Unit,
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(FeedScreenState())
    @AssistedFactory
    interface Factory{
        fun create(navigate: (Screen) -> Unit): FeedScreenViewModel
    }

}