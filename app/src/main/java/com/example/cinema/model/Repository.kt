package com.example.cinema.model

interface Repository {
    fun getFilmFromServer() : Film
    fun getFilmFromLocalStorage() : Film
}