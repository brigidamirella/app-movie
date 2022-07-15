package com.example.themovie.data

import androidx.room.*
import com.example.themovie.model.Movie

@Dao
interface TheMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movie: Movie)

    @Query("SELECT * from Movie WHERE id=:movieId")
    suspend fun getMovieDetail(movieId: Int): Movie

    @Query("SELECT * from Movie")
    suspend fun getAllMovies(): List<Movie>

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM Movie")
    suspend fun deleteAllMovies()
}