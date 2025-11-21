package com.leoevg.mihnewsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.leoevg.mihnewsapp.data.repository.LocalAuthManager
import com.leoevg.mihnewsapp.presentation.navigation.MainNav
import com.leoevg.mihnewsapp.presentation.ui.theme.MihNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var localAuthManager: LocalAuthManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MihNewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(
                        modifier = Modifier.padding(innerPadding),
                        isLoggedIn = localAuthManager.isLoggedIn()
                    )
                }
            }
        }
    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    isLoggedIn: Boolean
) {
    MainNav(
        navHostController = rememberNavController(),
        isLoggedIn = isLoggedIn,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    MihNewsAppTheme {
        MainContent(isLoggedIn = false)
    }
}
