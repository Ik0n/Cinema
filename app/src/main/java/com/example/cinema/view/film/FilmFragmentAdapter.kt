package com.example.cinema.view.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.model.Film
import com.squareup.picasso.Picasso

class FilmFragmentAdapter(private var onItemViewClickListener: OnItemViewClickListener?) :
    RecyclerView.Adapter<FilmFragmentAdapter.FilmViewHolder>() {

    private var filmsData: List<Film> = listOf()

    interface OnItemViewClickListener {
        fun onItemViewClick(film: Film)
    }

    fun setFilms(data : List<Film>) {
        filmsData = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    inner class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(film: Film) {
            Picasso.get().load(film.avatar).into(itemView.findViewById<ImageView>(R.id.film_avatar_list))
            itemView.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(film)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.films_recycler_item,
                parent,
                false) as View
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(filmsData[position])
    }

    override fun getItemCount(): Int {
        return filmsData.size
    }
}