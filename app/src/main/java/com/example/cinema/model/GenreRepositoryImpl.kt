package com.example.cinema.model

class GenreRepositoryImpl : GenreRepository {
    override fun getGenreFromServer(): List<Genre> {
        return getGenreList()
    }

    override fun getGenreFromLocalStorage(): List<Genre> {
        return getGenreList()
    }
}