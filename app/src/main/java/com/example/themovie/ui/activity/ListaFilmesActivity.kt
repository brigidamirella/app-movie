package com.example.themovie.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovie.api.MovieApiInterface
import com.example.themovie.api.MovieApiService
import com.example.themovie.databinding.ActivityMainBinding
import com.example.themovie.model.Movie
import com.example.themovie.model.MovieResponse
import com.example.themovie.ui.details.DetailActivity
import com.example.themovie.ui.recyclerview.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaFilmesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(this, movies) {
                val intent = Intent(this, DetailActivity::class.java)
                val bundle = Bundle()
                bundle.putString("titulo", it.title)
                bundle.putString("data", it.release)
                bundle.putString("descricao", it.overview)
                bundle.putString("imagem", it.backdrop)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}