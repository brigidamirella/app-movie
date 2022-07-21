package com.example.themovie.ui.Favorites

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.themovie.R
import com.example.themovie.databinding.ActivityFavoritesBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_favorites.*


class FavoritesActivity : AppCompatActivity() {

    private lateinit var viewModel: FavoritesViewModel
    private val binding by lazy { ActivityFavoritesBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        setContentView(binding.root)
        setSupportActionBar(favorite_appBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.favorites_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_delete -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Excluir tudo")
                    .setMessage("Você tem certeza que quer excluir todos?")

                    .setPositiveButton("Sim") { dialog, which ->
                        viewModel.deleteAllFavoritesMovies()
                    }
                    .setNegativeButton("Não") { dialog, wich ->

                    }.setCancelable(true)
                    .show()
            }
        }
        return super.onOptionsItemSelected(item)

    }

}