package com.example.themovie.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themovie.model.Movie

class DetailViewModel : ViewModel(){
    private val movie = MutableLiveData<Movie>()
    fun getMovie(): LiveData<Movie> = movie

}