package com.example.themovie.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovie.R
import com.example.themovie.api.MovieApiInterface
import com.example.themovie.api.MovieApiService
import com.example.themovie.data.local.AppDataBase
import com.example.themovie.databinding.ActivityMainBinding
import com.example.themovie.model.Movie
import com.example.themovie.model.MovieResponse
import com.example.themovie.ui.Favorites.FavoritesActivity
import com.example.themovie.ui.details.DetailActivity
import com.example.themovie.ui.recyclerview.adapter.MovieAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvMoviesList.layoutManager = LinearLayoutManager(this)
        binding.rvMoviesList.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            binding.rvMoviesList.adapter = MovieAdapter(this, movies) {
                val intent = Intent(this, DetailActivity::class.java)
                val bundle = Bundle()
                bundle.putString("title", it.title)
                bundle.putString("date", it.release)
                bundle.putString("overview", it.overview)
                bundle.putString("image", it.backdrop)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorites -> {
                Intent(this, FavoritesActivity::class.java)
                    .apply {

                        startActivity(this)
                    }
            }

        }
        return super.onOptionsItemSelected(item)

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