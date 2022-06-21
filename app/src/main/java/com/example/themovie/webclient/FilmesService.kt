package com.example.themovie.webclient

import com.example.themovie.model.Filme
import retrofit2.Call
import retrofit2.http.GET

interface FilmesService {
    @GET("movie/popular")
fun buscaFilmes(): Call<List<Filme>>

}