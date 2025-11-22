package com.leoevg.mihnewsapp.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.leoevg.mihnewsapp.R
import com.leoevg.mihnewsapp.domain.model.NewsItem
import com.leoevg.mihnewsapp.presentation.ui.theme.MihNewsAppTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun NewsItem(
    modifier: Modifier = Modifier,
    newsItem: NewsItem,
    onFavoriteClicked: () -> Unit,
    onReadClicked: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp, 8.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = newsItem.imageUrl,
                contentDescription = "News image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = newsItem.title,
                    fontSize = 22.sp
                )
                IconButton(
                    onClick = onFavoriteClicked
                ) {
                    Icon(
                        imageVector = if (newsItem.isFavorite) Icons.Filled.Favorite
                        else Icons.Outlined.Favorite,
                        contentDescription = "Добавить в избранное"
                    )
                }
            }

            Text(
                text = newsItem.description,
                maxLines = 3,
                fontSize = 18.sp
            )
            StyledButton(
                onClick = onReadClicked
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(R.string.read))
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        imageVector = Icons.Outlined.ArrowUpward,
                        contentDescription = "Стрелка",
                        modifier = Modifier
                            .rotate(90f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsItemPreview() {
    MihNewsAppTheme{
        NewsItem(
            newsItem = NewsItem(
                id = "1",
                title = "News item 1",
                description = "Description",
                publishedBy = "News source",
                publishedAt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).toString(),
                imageUrl = "",
                content = "",
                isFavorite = true
            ),
            onFavoriteClicked = {},
            onReadClicked = {}
        )
    }
}
