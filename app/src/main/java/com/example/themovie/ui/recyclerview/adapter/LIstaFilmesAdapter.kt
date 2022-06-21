package com.example.themovie.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.R
import com.example.themovie.model.Filme

class ListaFilmesAdapter(
    private val context: Context,
    filmes: List<Filme>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val filmes = filmes.toMutableList()

    private fun RecyclerView.ViewHolder.vincula(filme: Filme) {
        val nome = itemView.findViewById<TextView>(R.id.filmes_item_nome)
        nome.text = filme.nome
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.filme_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.vincula(filme)
    }

    override fun getItemCount(): Int = filmes.size
    fun atualiza(produtos: List<Filme>) {
        this.filmes.clear()
        this.filmes.addAll(produtos)
        notifyDataSetChanged()
    }

}







