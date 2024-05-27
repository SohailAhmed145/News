package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.network.ApiProvider
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.screen.HomeApp
import com.example.screen.NewsViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: NewsViewModel by viewModels()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "NewsApp",
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = { /* Handle navigation icon click */ }) {
                                    Icon(
                                        Icons.Filled.Menu,
                                        contentDescription = "Menu Icon",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clip(CircleShape),
                                        tint = Color.White
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = { /* Handle search icon click */ }) {
                                    Icon(
                                        Icons.Filled.Search,
                                        contentDescription = "Search Icon",
                                                modifier = Modifier
                                                    .size(30.dp)
                                                    .clip(CircleShape),
                                        tint = Color.White

                                    )
                                }
                                IconButton(onClick = { /* Handle profile icon click */ }) {
                                    Icon(
                                        Icons.Filled.AccountCircle,
                                        contentDescription = "Profile Icon",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clip(CircleShape),
                                        tint = Color.White
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(Color(0xFF063AD5)),
                        )

                        Box(
                            modifier = Modifier
                                .background(Color.White)
                                .padding(10.dp)
                                .fillMaxSize(),
                        ){
                            if (viewModel.res.value == null) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {

                                    CircularProgressIndicator()
                                }
                            }else{
                                HomeApp(viewModel = viewModel)
                            }
                        }
                    }


                }
            }
        }
    }
}

