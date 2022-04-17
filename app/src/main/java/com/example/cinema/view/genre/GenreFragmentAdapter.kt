package com.example.cinema.view.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.model.Film
import com.example.cinema.model.Genre
import com.example.cinema.view.film.FilmDetailsFragment
import com.example.cinema.view.film.FilmFragmentAdapter
import com.squareup.picasso.Picasso

class GenreFragmentAdapter(private var onGenreClickListener: OnGenreClickListener?) :
    RecyclerView.Adapter<GenreFragmentAdapter.GenreViewHolder>() {

    private var genres : List<Genre> = listOf()

    interface OnGenreClickListener {
        fun onItemViewClick(genre : Genre)
    }


    inner class GenreViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(genre: Genre) {
            itemView.findViewById<TextView>(R.id.genre_recycler_item_title).text = genre.title
        }
    }

    fun setGenres(data : List<Genre>) {
        genres = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.genre_recycler_item,
                parent,
                false) as View
        )
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(genres[position])
    }

    override fun getItemCount(): Int {
        return genres.size
    }
}