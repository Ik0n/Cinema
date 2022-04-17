package com.example.cinema.viewmodel

import com.example.cinema.model.Film
import com.example.cinema.model.Genre

sealed class GenreAppState {
    data class Success(val genres: List<Genre>) : GenreAppState()
    data class Error(val error: Throwable) : GenreAppState()
    object Loading : GenreAppState()
}