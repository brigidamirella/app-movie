package com.example.themovie.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovie.databinding.MovieItemBinding
import com.example.themovie.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val context: Context,
    private val movies: List<Movie>,
    val onMovieClick: (Movie) -> Unit

) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        fun bindMovie(movie: Movie, onMovieClick: (Movie) -> Unit) {
            itemView.movie_title.text = movie.title
            itemView.movie_release_date.text = movie.release

            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
            binding.root.setOnClickListener {
                onMovieClick(movie)
            }
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)

    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {



        holder.bindMovie(movies.get(position), onMovieClick)

    }
}