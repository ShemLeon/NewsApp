package com.leoevg.mihnewsapp.presentation.screen.main.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leoevg.mihnewsapp.data.repository.NewsRepository
import com.leoevg.mihnewsapp.domain.model.NewsItem
import com.leoevg.mihnewsapp.presentation.navigation.Screen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class FeedScreenViewModel @AssistedInject constructor(
    @Assisted val navigate: (Screen) -> Unit,
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(FeedScreenState())
    val state = _state.asStateFlow()

    private var news: List<NewsItem> = emptyList()


    fun onEvent(event: FeedScreenEvent) {
        when (event) {
            is FeedScreenEvent.NewsItemClicked -> TODO()
            is FeedScreenEvent.SearchQueryChanged -> onSearchQueryChanged(event.newSearchQuery)
        }
    }

    private fun onSearchQueryChanged(newQuery: String) {
        _state.update { it.copy(searchQuery = newQuery) }

        viewModelScope.launch {
            val filteredNews = withContext(Dispatchers.Default) {
                news.filter{it.title.contains(newQuery)}
            }
            _state.update { it.copy(filteredNews = filteredNews) }
        }


    }

}

@AssistedFactory
interface Factory {
    fun create(navigate: (Screen) -> Unit): FeedScreenViewModel
}

}