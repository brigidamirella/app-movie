package com.example.themovie.data

import androidx.room.*
import com.example.themovie.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface TheMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovie(movies: List<Movie>)

    @Query("SELECT * from movie WHERE id=:movieId")
    suspend fun getMovieDetail(movieId: Int): Movie

    @Query("SELECT * from movie")
    suspend fun getAllMovies(): List<Movie>

    @Query("SELECT * from movie")
    fun getMoviesFlow(): Flow<List<Movie>>

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM Movie")
    suspend fun deleteAllMovies()
}