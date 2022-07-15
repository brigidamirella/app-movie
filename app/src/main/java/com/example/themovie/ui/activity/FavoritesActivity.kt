package com.example.themovie.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.themovie.databinding.ActivityFavoritesBinding


class FavoritesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFavoritesBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }


}