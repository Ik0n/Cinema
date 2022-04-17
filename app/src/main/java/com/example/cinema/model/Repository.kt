package com.example.cinema.model

interface Repository {
    fun getFilmFromServer() : List<Film>
    fun getFilmFromLocalStorage() : List<Film>
}