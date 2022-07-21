package com.example.themovie.ui.details

import android.app.Application
import androidx.lifecycle.*
import com.bumptech.glide.load.engine.Resource
import com.example.themovie.data.TheMoviesDao
import com.example.themovie.data.local.AppDataBase
import com.example.themovie.data.repository.MovieRepository
import com.example.themovie.data.repository.MovieRepositoryImp
import com.example.themovie.model.Movie
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImp(application)

    val movie: MutableLiveData<Resource<Movie>> = MutableLiveData()


    fun addMovieDetailToFavorites(movie: Movie) {
        viewModelScope.launch {
            repository.addMovieToFavorites(movie)
        }
    }

    fun deleteMovieDetailFromFavorites(movie: Movie) {
        viewModelScope.launch {
            repository.deleteMovieFromFavorites(movie)
        }
    }


}