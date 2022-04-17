package com.example.cinema.model

interface GenreRepository {
    fun getGenreFromServer() : List<Genre>
    fun getGenreFromLocalStorage() : List<Genre>
}