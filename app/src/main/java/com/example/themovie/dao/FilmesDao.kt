package com.example.themovie.dao

import com.example.themovie.model.Filme

class FilmesDao {
    fun adiciona(filme: Filme) {
        filmes.add(filme)
    }

    fun buscaTodos(): List<Filme> {
        return filmes.toList()
    }

    companion object {
        private val filmes = mutableListOf<Filme>()
    }
}
