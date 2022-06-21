package com.example.themovie.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.R
import com.example.themovie.dao.FilmesDao
import com.example.themovie.model.Filme
import com.example.themovie.ui.recyclerview.adapter.ListaFilmesAdapter
import com.example.themovie.webclient.RetroftInicializador
import retrofit2.Response

class ListaFilmesActivity : AppCompatActivity(R.layout.activity_filmes_lista) {
    private val dao = FilmesDao()
    private val adapter = ListaFilmesAdapter(
        context = this, filmes = dao.buscaTodos()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmes_lista)
        title = "Lista de Filmes"

        val RecyclerView = findViewById<RecyclerView>(R.id.recycler_filmes)
        RecyclerView.adapter = ListaFilmesAdapter(
            this, filmes = listOf(
                Filme(nome = "Coração indomavel"),
                Filme(nome = "narnia"),
                Filme(nome = "amor verdadeiro")
            )
        )

        val call = RetroftInicializador().filmesService.buscaFilmes()
        val resposta: Response<List<Filme>> = call.execute()
        resposta.body()?.let { filmes ->

        }


        RecyclerView.layoutManager = LinearLayoutManager(this)
    }
}