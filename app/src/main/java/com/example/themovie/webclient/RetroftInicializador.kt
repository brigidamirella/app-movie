package com.example.themovie.webclient

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetroftInicializador {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val filmesService = retrofit.create(FilmesService::class.java)
}