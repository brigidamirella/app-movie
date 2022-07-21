package com.example.themovie.ui.Favorites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.themovie.data.repository.MovieRepositoryImp
import com.example.themovie.model.Movie
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepositoryImp(application)
    val movie: MutableLiveData<Resource<Movie>> = MutableLiveData()

    fun deleteAllFavoritesMovies() {
        viewModelScope.launch {
            repository.deleteAllFavoritesMovies()
            repository.getAllFavoritesMovies()
        }
    }
}