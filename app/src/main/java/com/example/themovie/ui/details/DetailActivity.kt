package com.example.themovie.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.themovie.databinding.FragmentDetailBinding


class DetailActivity : AppCompatActivity() {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    private val binding by lazy { FragmentDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
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
            }

        }
    }

}














