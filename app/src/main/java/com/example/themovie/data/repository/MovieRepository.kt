package com.example.themovie.data.repository

import com.example.themovie.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun addMovieToFavorites(movie: Movie)
    suspend fun getMovieFromFavorites(movieId: Long)
    suspend fun deleteMovieFromFavorites(movie: Movie)
    suspend fun getAllFavoritesMovies(): Flow<List<Movie>>
    suspend fun deleteAllFavoritesMovies()
}