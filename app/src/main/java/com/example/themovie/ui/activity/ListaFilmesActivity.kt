package com.example.themovie.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.R
import com.example.themovie.dao.FilmesDao
import com.example.themovie.model.Filme
import com.example.themovie.response.FilmesResponse
import com.example.themovie.ui.recyclerview.adapter.ListaFilmesAdapter
import com.example.themovie.webclient.RetroftInicializador
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
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


//
//        lifecycleScope.launch{
//            val listaResposta = RetroftInicializador().filmesService.buscaFilmes()
//            val filmes: List<FilmesResponse> = listaResposta.map {filmesResposta ->
//                filmesResposta.filme
//            }
//            Log.i("ListaNotas", "onCreate:$filmes")
//
//    }


        RetrofitConfig()

        RecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun RetrofitConfig() {
        val call: Call<List<FilmesResponse>> = RetroftInicializador().filmesService.buscaFilmes()
        call.enqueue(object : Callback<List<FilmesResponse>?> {
            override fun onResponse(
                call: Call<List<FilmesResponse>?>,
                resposta: Response<List<FilmesResponse>?>
            ) {
                resposta.body()?.let { filmesResponse ->

                    val filmes: List<FilmesResponse> = filmesResponse.map {
                        it
                    }

                    Log.i("ListaFilmes", "onCreate: $filmes")
                }
            }

            override fun onFailure(call: Call<List<FilmesResponse>?>, t: Throwable) {
                Log.e("ListaFilmes", "onFailure: ", t)
            }
        })
    }
}