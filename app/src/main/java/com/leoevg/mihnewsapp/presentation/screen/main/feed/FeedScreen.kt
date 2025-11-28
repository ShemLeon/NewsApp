package com.leoevg.mihnewsapp.presentation.screen.main.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leoevg.mihnewsapp.domain.model.NewsItem
import com.leoevg.mihnewsapp.presentation.ui.component.NewsItem as NewsItemView
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import com.leoevg.mihnewsapp.R
import com.leoevg.mihnewsapp.presentation.navigation.Screen
import com.leoevg.mihnewsapp.presentation.ui.component.NewsItem


@Composable
fun FeedScreen(
    navigate: (Screen) -> Unit
) {
    val viewModel = hiltViewModel<FeedScreenViewModel, FeedScreenViewModel.Factory>{
        it.create(navigate)
    }
    val state by viewModel.state.collectAsStateWithLifecycle()

    FeedScreenContent(
        state = state,
        onEvent = viewModel::onEvent
    )

}

@Composable
fun FeedScreenContent(
    state: FeedScreenState,
    onEvent: (FeedScreenEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = { onEvent(FeedScreenEvent.SearchQueryChanged(it)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Иконка поиска",
                    tint = Color.Gray
                )
            },
            placeholder = @androidx.compose.runtime.Composable {
                Text(
                    text = stringResource(R.string.search_through_news),
                    fontSize = 18.sp
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.9f)
        )
        Spacer(modifier = Modifier.height(10.dp))


        LazyColumn(
            modifier = Modifier
                .fillMaxSize(0.9f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(state.filteredNews) {
                NewsItem(
                    newsItem = it,
                    onFavoriteClicked = {},
                    onReadClicked = {
                        onEvent(FeedScreenEvent.NewsItemClicked(it))
                    }
                )
            }
        }
    }
}

