package com.example.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.NewsModel
import com.example.repo.Repo
import kotlinx.coroutines.launch

class NewsViewModel (): ViewModel(){

    var res = mutableStateOf<NewsModel?>(null)
    init {

        viewModelScope.launch {
           res.value =  getNews(Repo())

        }
    }
    suspend fun getNews(repo: Repo) : NewsModel?{

        return repo.newProvider().body()
//      emit(AsyncImagePainter.State.Loading(""))
//      try {
//          emit(Result.Success(data = repo.newProvider().body()))
//      }catch (e : Exception){
//          emit(AsyncImagePainter.State.Error(message = e.localizedMessage))
//      }

  }

}