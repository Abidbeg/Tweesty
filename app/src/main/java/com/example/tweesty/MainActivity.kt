package com.example.tweesty

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweesty.api.TweetsyApi
import com.example.tweesty.screens.CategoryPopularScreen
import com.example.tweesty.screens.CategoryScreen
import com.example.tweesty.screens.DetailsScreen
import com.example.tweesty.ui.theme.TweestyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweestyTheme {
                Scaffold() {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }
}


@Composable
fun App() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "categoryScreen") {
        composable("categoryScreen")
        {
            CategoryPopularScreen {
                navHostController.navigate("detailscreen/$it")
            }
        }
        composable(
            "detailscreen/{category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        )
        {
            DetailsScreen()
        }
    }
}