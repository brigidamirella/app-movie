package com.example.themovie.webclient

import com.example.themovie.response.FilmesResponse
import com.example.themovie.response.MovieDetails
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmesService {
    @GET("movie/popular")
fun buscaFilmes(): Call<List<FilmesResponse>>

@GET("movie/{movie_id}")
fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}