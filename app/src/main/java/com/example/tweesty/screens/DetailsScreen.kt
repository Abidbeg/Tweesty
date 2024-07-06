package com.example.tweesty.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweesty.R
import com.example.tweesty.viewmodels.TweetsModel

@Composable
fun DetailsScreen() {

    val tweestViewModel: TweetsModel = hiltViewModel()
    val tweet = tweestViewModel.tweet.collectAsState()
    LazyColumn {
        items(tweet.value) {
            DetailsScreenItem(Tweets = it.text)
        }
    }
}

@Composable
fun DetailsScreenItem(Tweets: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
        border = BorderStroke(
                1.dp,
                Color(0xFFCCCCCC)
            )
    ) {
        Text(
            text = Tweets,
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyMedium,

        )
    }

}