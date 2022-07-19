package com.example.themovie.api

import com.example.themovie.model.Movie
import com.example.themovie.model.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterface {

    @GET("movie/popular?api_key=458571bc66840f4d1764760ccce524e0")
    fun getMovieList(): Call<MovieResponse>

    @GET("movie/{id}?api_key=458571bc66840f4d1764760ccce524e0")
    fun getMovie(movieId: Int): Response<Movie>
}