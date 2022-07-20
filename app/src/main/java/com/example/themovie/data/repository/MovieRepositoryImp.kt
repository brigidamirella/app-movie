package com.example.themovie.data.repository

import android.content.Context
import com.example.themovie.api.MovieApiInterface
import com.example.themovie.data.TheMoviesDao
import com.example.themovie.data.local.AppDataBase
import com.example.themovie.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImp(context: Context) : MovieRepository{
    private lateinit var dao: TheMoviesDao
    private val database = AppDataBase.getDataBase(context).dao()

    override suspend fun addMovieToFavorites(movie: Movie) {
        dao.insertMovieDetail(movie)
    }

    override suspend fun getMovieFromFavorites(movieId: Int) {
        dao.getMovieDetail(movieId)
    }

     override suspend fun deleteMovieFromFavorites(movie: Movie) {
        dao.deleteMovie(movie)
    }

     override suspend fun getAllFavoritesMovies(): Flow<List<Movie>> = flow {
        val theSavedMovies = dao.getAllMovies()
        val theMovieList = theSavedMovies.map { it }
        emit(theMovieList)
    }
}