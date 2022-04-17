package com.example.cinema.model

class RepositoryImpl : Repository {
    override fun getFilmFromServer(): List<Film> {
        return getFilms()
    }

    override fun getFilmFromLocalStorage(): List<Film> {
        return getFilms()
    }
}