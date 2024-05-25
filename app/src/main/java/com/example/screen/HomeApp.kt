package com.example.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun HomeApp(modifier: Modifier = Modifier, viewModel: NewsViewModel){
    val res = viewModel.res.value?.articles!!
    LazyColumn (modifier = Modifier.fillMaxSize()){
        item (res){ 
            Card (){
               Column (){
                AsyncImage(
                    model = it.urlToImage,
                    contentDescription = null,
                )
                   Text(text = it.title)

               }
            }
        }

    }
}