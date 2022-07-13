package com.example.themovie.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.themovie.databinding.FragmentDetailBinding
import com.example.themovie.model.Movie
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailActivity : AppCompatActivity() {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    private val binding by lazy { FragmentDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }


    private fun DetailsMovie(movie: Movie) {
        movie_title.text = movie.title
        movie_release_date.text = movie.release
        txt_overView.text = movie.overview
        Glide.with(this)
            .load(IMAGE_BASE + movie.poster)
            .transform(CenterCrop())
            .into(movie_poster)

    }

    }














