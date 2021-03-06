package com.example.themovie.ui.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.themovie.data.local.AppDataBase
import com.example.themovie.databinding.FragmentDetailBinding
import com.example.themovie.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailActivity : AppCompatActivity() {
    private lateinit var database: AppDataBase
    private lateinit var movie: Movie
    var _isChecked = false
    private lateinit var viewModel: DetailViewModel
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    private val binding by lazy { FragmentDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        setContentView(binding.root)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        database = AppDataBase.getDataBase(this)
        setMovieData()
    }

    private fun setMovieData() {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            binding.movieTitle.text = bundle.getString("title", "")
            binding.movieReleaseDate.text = bundle.getString("date")
            binding.txtOverView.text = bundle.getString("overview")
            val linkImage = bundle.getString("image", "")
            if (linkImage != "") {
                Glide.with(this)
                    .load(IMAGE_BASE + linkImage)
                    .centerCrop()
                    .into(binding.moviePoster)

                binding.toggleFavorite.setOnClickListener {
                    _isChecked = !_isChecked
                    if (_isChecked) {
                        viewModel.addMovieDetailToFavorites(movie)
                    } else {
                        viewModel.deleteMovieDetailFromFavorites(movie)
                    }
                    binding.toggleFavorite.isChecked = _isChecked
                }

            }
        }

    }
}














