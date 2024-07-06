package com.example.tweesty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweesty.R
import com.example.tweesty.viewmodels.CategoryModel

@Composable
fun CategoryPopularScreen(onClick: (category: String) -> Unit) {

    val categoryViewModel: CategoryModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.category.collectAsState()

    if (categories.value.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center) {
            Text(text = "Loading...", style = MaterialTheme.typography.bodyLarge)
        }

    } else {

        Column {

            Row(horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.home), contentDescription = "Home")
                Text(
                    text = "Thursday, 27 July",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search"
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                items(categories.value.distinct()) {
                    CategotyPopularItem(Categoty = it, onClick)
                }
            }
            Text(text = "Popular Tweets", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun CategotyPopularItem(Categoty: String, onClick: (category: String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                onClick(Categoty)
            }
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(painter = painterResource(id = R.drawable.bg), contentScale = ContentScale.Crop)
            .border(
                1.dp,
                Color(0xFFEEEEEE)
            ),
        contentAlignment = Alignment.BottomCenter
    ) {

        Text(
            text = Categoty,
            color = Color.DarkGray,
            fontSize = 18.sp,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodyLarge

        )
    }
}